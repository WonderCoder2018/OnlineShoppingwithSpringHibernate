<%@ include file="../shared/flows-header.jsp" %>

<div class="container">

<div class="row">

<!-- To display all the goods -->

<div class="col-md-6">

<div class="row">

<c:forEach items="${checkoutModel.cartLines}" var="cartLine">
<div class="col-xs-12">

<div>

<h3>${cartLine.product.name}</h3>
<hr/>
<h4>Quantity - ${cartLine.productCount}</h4>
<h5>Buying Price - &#8377; ${cartLine.buyingPrice}/-</h5>


</div>
<hr/>
<div class="text-right">

<h3>Grand Total - &#8377; ${cartLine.total}/-</h3>



</div>

</div>

</c:forEach>



</div>

</div>

<div class="col-md-6">

<div class="panel panel-default">

<div class="panel-heading">

<h3 class="panel-title">

Payment Details

</h3>


</div>

<div class="panel-body">


<form role="form">

<div class="from-group row">


<label for="cardNumber">CARD NUMBER</label>
<div class="input-group">

<input type="text" class="form-control" id="cardNumber" placeholder="Valid Card Number"
required autofocus/>
<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>

</div>


</div>

<div class="row">

<div class="col-xs-7 col-md-7">

<div class="form-group row">


<label for="expiryMonth">EXPIRY DATE</label>

<br/>
<div class="col-xs-6 col-lg-6 pl-zero">

<input type="text" class="form-control" id="expiryMonth" placeholder="MM" required />


</div>

<div class="col-xs-6 col-lg-6 pl-zero">

<input type="text" class="form-control" id="expiryYear" placeholder="YY" required />

</div>
</div>


</div>


</div>

</form>


</div>
</div>


</div>

</div>

</div>