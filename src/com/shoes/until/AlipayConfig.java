package com.shoes.until;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016093000631318";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCc2lQn0gvvjQ6r+xJ+YnppejlACx3pFUhmhPIbluE2o2Kcb+YiMrjCaKFU6jD2Hq0toVxYa6QL4Q40lCIS51eN+axc4w+sOFvxUAy3SpWGm8z+ZYzDD///soP4hwmb5pgLPZsbx7Pvy0A2zr4zs7Ca4RqZADh30pp+qzqzhVouUdInTlrYDih0CfoNXtdzpdGO2Hq0FL60Np/iaXZ2SUs3bqy5rN0haj++aJoVs6bNwRtiTYjQLH0b1t4zXKEY05hHSN2FZhw6eRvry6nK4yiD0TOwrPK2adQScT2f5Pw6XGM96IpkQXf8m7/cT7IRz/aLnICX10l3XdW1d7c43Sy/AgMBAAECggEATVfrP2d3szvfDDbVu7RboD9Ak6/no9N2y/aqW6hejU6rhXA4DozsRhDJ3NFOK06dHm7+1irdzW3AT3TsCF5C8iM3NuZQCCASVj+exZLlgGa7AoaYjmcJWNBx+s67kkB2oLRUE7K5q3iRxXTUnTHx161ALEnLjmou/F76pyMOgN/YUCrpBktCJLup0hzE0YkZw2ppdpNYPiGmHiEbNgR8ifsgKZHBOR8GFmTkL+SMRj0eq3Jk3A5RmvF54mhDMnpuitL92PGBrc6HGGgrEntE7OntwPwzovXWmL0FGITAvLJfajWK/ABmUL2h2UOrln5fR8sjA+vuUOQrbbYyW+ZfAQKBgQDlV5yZc5Eq1ZQODBXcXTZ+gfsBZpElUlGbZUJ2VcFrexoRRJg9sABLfIc93DpvldgMRR8ucfrPsKVEMxGeX0o6ZMAG0Lz3gY1U0Z+T+YhOz6JdThZh8XZJ9FvVbK0zn8dTRBFTgXx/3Y4QXbw3OuTE6Ov1S+h4r0fg9CIJrjWP4QKBgQCvFbKBqQZyIeqCmYVihxlUyfjoa+1hSNjIysq3khFoSZgdjxy2bNE6hzAlRdt53a+qoTZ2ZEC3MzW++xxq/DmaLOx1JESMP9/rbJCBeDNXX5ZmwpWkQ3dYcYTN50fvH7TwUOClz2G9FEe/WMLonj8mjz8M534+yur8YHxuPvLQnwKBgQC7iqFseqzDMlQYCJn30eG2IeR4iL84ndBOGsf2rLm2grwWUtmL2FjlYbfWRjki9o3turh86ogHPpRm6LwHnjS8+5Zr/FYKr847BhBQmUV17SUA19JF1Ya9gy11oaEhDg+Zb5gbiU+d4DdD+uLm5yocO7x4otI/nlZRBlKvR95VAQKBgQCPrkiday5k/zxKDN6Parr4//6KDffyPCvbK8CMQQyT/sEckNNJSaeyVjrGe7uPGMQOTNo68i7BqP7USZKaoX5L7c3mm+q9BbYmpyM3fIL1kvYEQm83LD6GkDIiH0jDDcwY4uZYbAWTe08d0iOxbhv48tkVJ+xMb43DqxKyDmqJlQKBgCCmlTGC7S8wC/MLLhts0BnvN0fkfiiNEjROiDXPkSYwc3EszKVMh5JCe/5qDFdDCicqerMjh3zQp38SbOEy4HFr5vURAyvIGziwObaCEDnRr0+zUlrc4NBAEnzEb8ngXzrROm7d3L+GSarJYQ2Vxy27Xyj3m0rhmuRPKvGWl/8y";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnYZGqIzkH5ELxSYVR/MPHX7c0TmHYC81k852kqJJyQGCs/5KFO8se7pmEeTNw8awGgnC3gghE+cCY3K+pImISoaCEGqdeIqmg5DyAHeae0v8nqOyBQvv9gSmGnINUPwLvlyi9jPYTwBENG90j7xrMrvbgvy0pP3w6+IOeEh8xF/PxQWAK0uXNZzbWMOKDuj+OqW25gvd72WnBZlSOXZmBUrQf5eujNzuhRhi/49kNad0onmyzrKG7quULf+cPjiE2occJ9+QTqQfppSyCa2RD1F6obzq93MWYg9YxFmnGA+b5bEOyIBddNmP6E+L2XO+guXNBmS4YjK9HGE1qg0K7QIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8081/struts2/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8081/struts2/main/buy";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl ="https://openapi.alipaydev.com/gateway.do";// "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "E:\\workspace\\log";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

