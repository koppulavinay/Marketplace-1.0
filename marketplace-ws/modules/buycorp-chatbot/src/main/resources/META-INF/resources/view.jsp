<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="/init.jsp" %>

<%
	HttpServletRequest originalHttpServletRequest = PortalUtil.getOriginalServletRequest(request);
	HttpSession httpSession = originalHttpServletRequest.getSession();
	String accessToken = (String) httpSession.getAttribute("accessToken");
	String userType = (String) httpSession.getAttribute("userType");
	String userName = (String) httpSession.getAttribute("userName");
	//System.out.println("accessToken--> " + accessToken);
	//System.out.println("userId--> " + userId);
	//System.out.println("userName--> " + userName);
%>

<script>

	var accessToken = '<%= accessToken %>';
	var userType = '<%= userType %>';
	var userName = '<%= userName %>';
	
	if(accessToken == 'null'){
		accessToken = "";
	}
	
	if(userType == 'null'){
		userType = "pre-login";
	} else {
		userType = userType.toLowerCase();
	}
	
	if(userName == 'null'){
		userName = "";
	}
	
	console.log("accessToken--> " + accessToken);
	console.log("userId--> " + userType);
	console.log("userName--> " + userName);
	
	var serverUrl = 'https://e42.lightinfosys.com'; // Server URL 
	var apiUrl = 'https://e42.lightinfosys.com'
	var url_extension = '/assist';
	var api_extension = '/bot'
	var bot_id = 127
	
	var account_id = 22
	/*edit params here*/ 
	var paramsObject = {
		"user_type": userType,
		"user_name": userName,
		"base_url": "https://buycorpapi.intellectproduct.com", //base url should be "https://buycorpapi.intellectproduct.com" for UAT
		"token": accessToken,  // token need to set comes from ARX
		"train_or_publish": "publish"
	}
	
	var main_script = document.createElement('script');
	main_script.setAttribute("type","text/javascript");
	main_script.setAttribute("src", serverUrl + url_extension +"/js/outer-main.js");
	if (main_script.readyState) {
	  main_script.onreadystatechange = function () { // For old versions of IE
	    if (this.readyState == 'complete' || this.readyState == 'loaded') {
	      cb();
	    }
	  };
	} else {
		main_script.onload = cb;
	}
	
	function cb() {
		var ddd = new NLPbot();
	}
	
	(document.getElementsByTagName("head")[0]).appendChild(main_script);

</script>