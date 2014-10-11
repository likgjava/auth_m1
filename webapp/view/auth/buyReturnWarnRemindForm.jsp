<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/commons/taglibs.jsp"%>
<style>
.remindTable {width: 100%;}
.remindTable tr {line-height: 30px;}
</style>
<form id="remindForm" method="post">
<input type="hidden" name="id" value="${remind.id }" />
<input type="hidden" name="buyOrderId" value="${remind.buyOrderId }" />
<input type="hidden" name="buyOrderCode" value="${remind.buyOrderCode }" />
<table class="remindTable">
	<tr>
		<td width="110px" align="right">订单编号：</td>
		<td>${remind.buyOrderCode }</td>
	</tr>
	<tr>
		<td align="right">产品线：</td>
		<td>${remind.productLineName }</td>
	</tr>
	<tr>
		<td align="right">订单录入人：</td>
		<td>${remind.buyOrderCreateUsername }</td>
	</tr>
	<tr>
		<td align="right">活动开始时间：</td>
		<td><fmt:formatDate value="${remind.eventStartDate }" pattern="yyyy-MM-dd" /></td>
	</tr>
	<tr>
		<td align="right">活动结束时间：</td>
		<td><fmt:formatDate value="${remind.eventEndDate }" pattern="yyyy-MM-dd" /></td>
	</tr>
	<tr>
		<td align="right">退货期：</td>
		<td>
			<input type="text" name="returnPeriod" size="8" class="easyui-numberbox" min="1" max="9999" required="true" value="${remind.returnPeriod }" />天
		</td>
	</tr>
	<tr>
		<td align="right">提醒时间：</td>
		<td>
			<input type="text" name="remindTime" size="8" class="easyui-numberbox" min="1" max="9999" required="true" value="${remind.remindTime }" />天
			<span style="color:gray;">（在退货期结束前提前多少天开始提醒）</span>
		</td>
	</tr>
	<tr>
		<td align="right">接收提醒人：</td>
		<td>
			<input id="combo" type="text" style="width:200px;" />
			<div id="reminderList">
				<div style="color:#99BBE8;background:#fafafa;padding:5px;">选择接收提醒人</div>
				<c:forEach var="remindManage" items="${remindManageList }">
					<c:set var="isSelected" value="0" />
					<c:forEach var="reminder" items="${remind.reminderList }">
						<c:if test="${remindManage.operatorUserId == reminder.operatorUserId}">
							<c:set var="isSelected" value="1" />
						</c:if>
					</c:forEach>
					<input style="vertical-align:middle;" type="checkbox" name="reminder" <c:if test="${isSelected == 1}">checked="checked"</c:if> value="${remindManage.operatorUserId }" /><span>${remindManage.operatorUsername }</span><br/>
				</c:forEach>
			</div>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
//获取选中的用户名
function getSelectedText(){
	var text = '';
	$('#reminderList input:checked').each(function(i,dom){
		text += (i>0 ? ',' : '') + $(dom).next('span').text();
	});
	return text;
}

$(function(){
	//初始化下拉复选框
	$('#combo').combo({
		required:true,
		editable: false
	});
	$('#reminderList').appendTo($('#combo').combo('panel'));
	$('#reminderList input').click(function(){
		$('#combo').combo('setText', getSelectedText());
	});
	$('#combo').combo('setText', getSelectedText());
});
</script>