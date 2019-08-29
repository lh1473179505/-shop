<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.ResultSet"%><%-- 导入java.sql.ResultSet类 --%>
<%-- 创建com.tools.ConnDB类的对象 --%>


<%


	//ResultSet rs = conn
			//.executeQuery("select * from tb_goods t1,tb_subType t2 where t1.typeID=t2.ID and t2.superType="
					//+ Integer.parseInt(type) + " order by INTime Desc");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>图书列表-51商城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/mr-01.css" type="text/css">

<script src="${pageContext.request.contextPath}/front/js/jsArr01.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/module.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/jsArr02.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/tab.js" type="text/javascript"></script>
</head>

<body>
	<jsp:include page="index-loginCon.jsp" />
	<!-- 网站头部 -->
	<%@ include file="common-header.jsp"%>
	<!-- //网站头部 -->
	<div id="mr-mainbody" class="container mr-mainbody">
		<div class="row">
			<!-- //分页显示图书列表 -->
			<div id="mr-content"
				class="mr-content col-xs-12 col-sm-12 col-md-9 col-md-push-3">

				<div id="system-message-container" style="display: none;"></div>

				<div id="mrshop" class="mrshop common-home">
					<div class="container_oc">
						<ul class="breadcrumb">
						</ul>
						<div class="row">
							<div id="content_oc" class="col-sm-12">
								<div class="box_oc">
									<div class="box-heading">
										<h1 class="mrshop_heading_h1">${typeName }</h1>
									</div>
									<div class="box-content">
										<hr>
										<div class="row">
									<c:forEach items="${newGoods.list}" var="newGoods">

											<div
												class="product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12">
												<div class="product-thumb">
													<div class="actions">
														<div class="image">
															<a style="width: 95%" href="${pageContext.request.contextPath}/showOneGoods?ID=${newGoods.id }"><img
																src="${pageContext.request.contextPath}/images/goods/${newGoods.picture }"
																class="img-responsive"> </a>
														</div>
														<div class="button-group btn-grid">
															<div class="cart">
																<button class="btn btn-primary btn-primary"
																	type="button" data-toggle="tooltip"
																	onclick='javascript:window.location.href="${pageContext.request.contextPath}/insertCart?goodsID=${newGoods.id }&num=1"; '
																	style="display: none; width: 33.3333%;"
																	data-original-title="添加到购物车">
																	<i class="fa fa-shopping-cart"></i>
																</button>
															</div>
															<div class="wishlist">
																<button class="btn" type="button" data-toggle="tooltip"
																	title="收藏">
																	<i class="fa fa-heart"></i>
																</button>
															</div>
														</div>
													</div>
													<div>
														<div class="caption">
															<div class="name">
																<a href="${pageContext.request.contextPath}/showOneGoods?ID=${newGoods.id }" style="width: 95%">
																	<span style="color: #0885B1">名称：${newGoods.goodsName }</span>1</a>
															</div>

															<p class="price">
																<span class="price-new">分类：</span> <span>${typeName }</span>
																<br>
																<span class="price-tax">价格: ${newGoods.nowPrice }元
																</span>
															</p>
														</div>

													</div>
												</div>
											</div>
											</c:forEach>
										</div>
										<div class="row pagination">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td height="30" align="right" style="font-size: 15px">当前是第【${newGoods.pageNum }】页,一共有【${newGoods.pages }】页，总记录数为【${newGoods.total}】&nbsp;
													<br><br>
													<ul style="font-size: 20px; ">
																		<li style="float: left;list-style: none;">
															    			 <a href="${pageContext.request.contextPath }/showGoods?Page=1&type=${type}">首页&nbsp;&nbsp;&nbsp;&nbsp;</a>
															    		</li>
															    		
															    		<li style="float: left;list-style: none;">
															    			 <a href="${pageContext.request.contextPath }/showGoods?Page=${newGoods.prePage }&type=${type}">上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
															    		</li>
														
														
															<c:forEach items="${newGoods.navigatepageNums }" var="i">
															    <c:choose>
															    	<c:when test="${newGoods.pageNum==i }">
															    		<li style="float: left;list-style: none;">
															    		<a href="${pageContext.request.contextPath }/showGoods?Page=${i}&type=${type}">${i}&nbsp;&nbsp;&nbsp;&nbsp;</a>
															    		</li>
															    	</c:when>
															    	
															    	<c:otherwise>
															    		<li style="float: left;list-style: none;">
															    		<a href="${pageContext.request.contextPath }/showGoods?Page=${i}">${i}&nbsp;&nbsp;&nbsp;&nbsp;</a>
															    		</li>
															    	</c:otherwise>
															    	
															    </c:choose>
														    		
														    </c:forEach>
																		<li style="float: left;list-style: none;">
															    			<a href="${pageContext.request.contextPath }/showGoods?Page=${newGoods.nextPage }&type=${type}">下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
															    		</li>
																		<li style="float: left;list-style: none;">
															    			<a href="${pageContext.request.contextPath }/showGoods?Page=${newGoods.pages }&type=${type}">末页&nbsp;&nbsp;&nbsp;&nbsp;</a>
															    		</li>
														
														
														</ul>
													</td>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //分页显示图书列表 -->
			<!-- 显示左侧热门商品 -->
			<jsp:include page="leftHotGoods.jsp">
				<jsp:param name="type" value="1" />
			</jsp:include>
			<!-- // 显示左侧热门商品 -->
		</div>
	</div>
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->
</body>
</html>