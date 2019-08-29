<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="row">

		<c:forEach items="${newGoods}" var="newGoods">
		
	<div class="col-lg-2 col-md-3 col-sm-4 col-xs-12">
		<div class="product-grid transition">
			<div class="actions">
				<div class="image">
					<a href="${pageContext.request.contextPath}/showOneGoods?ID=${newGoods.id }"><img
						src="${pageContext.request.contextPath}/images/goods/${newGoods.picture }"> </a>
				</div>
				<div class="button-group">
					<div class="cart">
						<button class="btn btn-primary btn-primary" type="button"
							data-toggle="tooltip" title=""
							onclick='javascript:window.location.href="${pageContext.request.contextPath}/insertCart1?goodsID=${newGoods.id }&num=1"; '
							data-original-title="加入购物车">
							<i class="fa fa-shopping-cart"></i>
						</button>
					</div>

				</div>
			</div>
			<div class="caption">
				<div class="name" style="height: 40px">
					<a style="width: 90%" href="${pageContext.request.contextPath}/showOneGoods?ID=${newGoods.picture }"><span
						style="color: #0885B1">名称:</span> ${newGoods.goodsName } </a>
				</div>


				<p class="price" style="margin-top: 40px">
					<span class="price-tax">价格:${newGoods.nowPrice } 元
					</span>
				</p>
			</div>
		</div>
	</div>
	</c:forEach>

</div>