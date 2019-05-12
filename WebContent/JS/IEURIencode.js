/**
 * document.body.onload=
 */
function uriencoding(txt){
	if(window.ActiveXObject || "ActiveXObject" in window){
		var alist=document.getElementsByClassName("link");
		for(var index=0;index<alist.length;index++){
			alist[index].href=encodeURI(alist[index].href);
			console.log(alist[index].href)
	   }
		//alert(txt)
	}
}
//window.onload=uriencoding("onload")
//window.onunload=uriencoding("onunload")
window.onreload=uriencoding("onreload")
