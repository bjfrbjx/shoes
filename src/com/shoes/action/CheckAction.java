package com.shoes.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shoes.entity.Orders;
import com.shoes.entity.Preorder;
import com.shoes.entity.Shoes;
import com.shoes.entity.Users;
import com.shoes.until.AlipayConfig;
import com.shoes.until.Service;

public class CheckAction extends ActionSupport {
	/**
	 * 
	 */
	private int index=1;
	private static final int clumns=10;
	Service service=null; 
	private Preorder preord=new Preorder();
	private Orders order=new Orders();
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}

	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Preorder getPreord() {
		return preord;
	}
	public void setPreord(Preorder preord) {
		this.preord = preord;
	}
	public CheckAction() {
		// TODO 自动生成的构造函数存根
	}
	public String createpreorder() throws UnsupportedEncodingException, SQLException {
		HttpServletRequest request=ServletActionContext.getRequest();
		String username= ((Users)request.getSession().getAttribute("user")).getName();	
		this.preord.setUserid(username);
		if(preord.getPreorderid()==null) {
		String orderID=username+"-"+Integer.toHexString((int) (Math.random()*1000))+"-"+this.preord.getShoeid();
		this.preord.setPreorderid(orderID);
		}
		else {
			this.rempreord();
		}
		request.getSession().setAttribute("payorder",preord);
		Shoes shoe=new Shoes();
		shoe.setShoeId(preord.getShoeid());
		shoe=service.getone(shoe);
		if(shoe!=null){
		ActionContext.getContext().getValueStack().set("singleprice", shoe.getPrice());
		ActionContext.getContext().getValueStack().set("subject", shoe.getBrand()+shoe.getSex()+shoe.getKind());
		return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	public String createorder() {
		HttpServletRequest request=ServletActionContext.getRequest();
		this.order=(Orders) request.getSession().getAttribute("payingord");
			service.addOder(this.order);
			System.out.println("ord");
			return SUCCESS;
		
	}
	public String shopping() throws UnsupportedEncodingException, SQLException {
		HttpServletRequest request=ServletActionContext.getRequest();
		this.createpreorder();
		service.addpreorder(preord);
		List<Preorder> pds=(List<Preorder>)request.getSession().getAttribute("preorder");
		pds.add(preord);
		return SUCCESS;
	}
	public String getorders() {
			return innerOrderspage();
	}
	public String cleanpreord() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Users u=(Users)request.getSession().getAttribute("user");
		if(u!=null&&!u.getName().equals("")) {
			service.cleanpreord(u);
			((List<Preorder>)request.getSession().getAttribute("preorder")).clear();
			}
		return SUCCESS;
		
	}
	public String rempreord() throws  SQLException {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		if(this.preord.getPreorderid()!=null) {
			List<Preorder> pl=(List<Preorder>)request.getSession().getAttribute("preorder");
			pl.remove(this.preord);
			service.removepreord(this.preord);
			return SUCCESS;
		}
		return ERROR;
	}
	public String getpageorders(){
		return innerOrderspage();
	}
	private String innerOrderspage(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users u=(Users)session.getAttribute("user");
		int allordsnum = service.getorder((Users)session.getAttribute("user")).size();
		int maxindex=(int)Math.floor(allordsnum/10);
		if(allordsnum%10!=0) maxindex++;
		index=index<1?1:(index>maxindex?maxindex:index);
		List<Orders> orders=service.getorder(index,clumns,u);
		ActionContext.getContext().getValueStack().set("maxindex",maxindex);
		ActionContext.getContext().getValueStack().set("allordsnum",allordsnum);
		ActionContext.getContext().getValueStack().set("clumns",clumns);
		ActionContext.getContext().put("orders", orders);
		return SUCCESS;
	}
	public void testpay() throws IOException{
		HttpServletRequest request =ServletActionContext.getRequest();
		HttpServletResponse response =ServletActionContext.getResponse();
		request.getSession().setAttribute("payingord", this.order);
		//获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
      //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = order.getOrderid();
        //付款金额，必填
        String total_amount = order.getSumpric().toString();
        //订单名称，必填
        String subject = order.getSubject();
        //商品描述，可空
        String body = "商品描述";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
                + "\"total_amount\":\""+ total_amount +"\"," 
                + "\"subject\":\""+ subject +"\"," 
                + "\"body\":\""+ body +"\"," 
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
            response.setContentType("text/html;charset=" + AlipayConfig.charset);
            response.getWriter().write(result);//直接将完整的表单html输出到页面
            response.getWriter().flush();
            response.getWriter().close();
        } catch (AlipayApiException e) {
            e.printStackTrace();
            response.getWriter().write("捕获异常出错");
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

