<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/link.jsp" %>
<link rel="stylesheet" href="/css/layout/nav.css">
<link rel="stylesheet" href="/css/home.css">
 
<%@ include file="/WEB-INF/view/include/header.jsp" %>
 	<!-- 콘텐츠 -->
    <div class="wrap">
        <main>
            <section class="address_search">
                 <div id="search_box">
                     <div>
                         <input type="hidden" id="deleveryAddress1" placeholder="우편번호" value="${BMaddress.address1 }" name="address1" readonly>
                   		 <input type="text" value="${BMaddress.address2 }" 
                         		id="deleveryAddress2" readonly placeholder="배달 받으실 주소를 입력해 주세요" name="address2" onclick="modifyAddress()"><br>     
                         <input type="text" id="deleveryAddress3" value="${BMaddress.address3 }"  name="address3" placeholder="상세주소를 입력해주세요">                 		
                     </div>
 
                     <div class="search_btn">
                         <label for="search_btn">
                             <i class="fas fa-search"></i>
                         </label>
 
                         <input type="button" name="search" id="search_btn">
 
                     </div>
 					<%@ include file="/WEB-INF/view/include/modifyAddress.jsp" %>
                 </div>
            </section>
            <section class="category_box">
                <div class="box">
                    <ul class="category">
                    
                                <li>
									<div>
										<div class="img_box">
                                           <img src="/img/jeungryu.png" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">일반증류주</div>
                                </li>
                    
                                <li>
									<div>
										<div class="img_box">
                                           <img src="/img/soju.png" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">증류식소주</div>
                                </li>
                    
                                <li>
									<div>
										<div class="img_box">
                                           <img src="/img/chungju.jpg" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">청주</div>
                                </li>
                    
                                <li>
									<div>
										<div class="img_box">
                                           <img src="/img/tacju.jpg" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">탁주</div>
                                </li>
                                
                    
                                <li>
									<div>
										<div class="img_box">
                                           <img src="/img/saengtacju.jpg" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">생탁주</div>
                                </li>
                                
                                <li>
									<div>
										<div class="img_box">
                                           <img src="/img/fruit.jpg" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">과실주</div>
                                </li>
                    
                                <li>
									<div>
										<div class="img_box">
                                           <img src="/img/liquor.jpg" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">리큐르</div>
                                </li>
                                
                    
                                <li>
									<div>
										<div class="img_box">
                                           <img src="/img/yackju.jpg" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">약주</div>
                                </li>
                    
                                <li>
									<div>
										<div class="img_box">
                                           <img src="/img/blandy.jpg" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">브랜디</div>
                                </li>    
                                <li>
									<div>
										<div class="img_box">
                                           <img src="/img/etcju.jpg" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">기타주류</div>
                                </li>                                              
                            </ul>
                	</div>
            </section>
        </main>
    </div>
    <!-- 콘텐츠 -->
 
 
    <!-- 하단 메뉴 -->
	<%@ include file="/WEB-INF/view/include/nav.jsp" %>
    <!-- 하단 메뉴 -->
    <!-- 푸터 -->
    <%@ include file="/WEB-INF/view/include/footer.jsp" %>
    <!-- 푸터 -->
 
<script>
	$(".category li").click(function(){
		let address1 = $("#deleveryAddress1").val();
		if(!address1) {
			swal("배달 받으실 주소를 입력해 주세요");
			return false;
		}
		
		const index = $(this).index();
		
		location.href = "/store/" + (100+index) + "/" +address1;
	})
 
</script>
 
 
</body>
 
</html>