<%@include file="/WEB-INF/jsp/webServices/head.jsp"%>

<body>
	<section id="container">

		<%@include file="/WEB-INF/jsp/webServices/SideTopBar.jsp"%>

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
          	
          	<!-- BASIC FORM ELELEMNTS -->
          	<div class="row mt">
          		<div class="col-lg-12">
                  <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> Check if a String is Palindrome</h4>
                      <form id="myForm" class="form-horizontal style-form">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"> Insert a String:</label>
                              <div class="col-sm-10">
                                  <input id="inputStr" type="text" class="form-control" autocomplete="off">
                                  <span class="help-block">Default = "False".</span>
                                  <button type="submit" class="btn btn-theme">Submit</button>
                              </div>
                          </div>
                        
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Result Output</label>
                              <div class="col-sm-10">
                                  <span class="form-control" id="resultBox"></span>
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">JSON Output</label>
                              <div class="col-sm-10">
                                  <span class="form-control" id="resultBoxJSON" style="height:50px;"></span>
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">API available at: </label>
                          
                              <label class="col-sm-6 col-sm-6 control-label" style="font-weight:bold"> jonathanhdez.com/api/isPalindrome</label>
                          </div>
                          
                      </form>
                  </div>
          		</div><!-- col-lg-12-->      	
          	</div><!-- /row -->
          	
		</section>
		</section>

	</section>

	<%@include file="/WEB-INF/jsp/webServices/generalScripts.jsp"%>
	
	<script>
		$('#myForm').submit(function(event) {
			event.preventDefault();
			$.getJSON("${pageContext.request.contextPath}/api/isPalindrome",{ str:$('#inputStr').val()}).done( 
		   		function(isPalindrome) {
		                $("#resultBox").text(isPalindrome.isPalindrome);
		                $("#resultBoxJSON").text(JSON.stringify(isPalindrome));
			    }).fail(
		   		function(){
		   			console.log("Se jodio esto");
		   		}		
		    );
		});
	</script>

</body>
</html>