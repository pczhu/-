<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理页面</title>
<!-- 调用CSS，JS -->
<script src="js/prototype.lite.js" type="text/javascript"></script>
<script src="js/moo.fx.js" type="text/javascript"></script>
<script src="js/moo.fx.pack.js" type="text/javascript"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/body.css" rel="stylesheet" type="text/css" />

<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	background-color: #2286C2;
}
-->


</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="74" colspan="2" background="images/index1_03.gif">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="33%" rowspan="2"><img src="images/index1_01.gif" width="253" height="74" /></td>
          <td width="6%" rowspan="2">&nbsp;</td>
          <td width="61%" height="38" align="right">
            <table width="120" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="center"><img src="images/index1_06.gif" width="16" height="16" /></td>
                <td align="center"><img src="images/index1_08.gif" width="16" height="16" /></td>
                <td align="center" class="font2"><a href="/ZhuNewsManager/logout" class="font2"><strong>退出</strong></a></td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td align="right">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="right" class="font2">
                &nbsp;|&nbsp;登陆用户：${sessionScope.logininfo.userName}&nbsp;|&nbsp;身份：
                <c:if test="${sessionScope.logininfo.userPower == 2}">管理员</c:if>
                <c:if test="${sessionScope.logininfo.userPower == 1}">发布员</c:if>
                &nbsp;|&nbsp;&nbsp;</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <table width="100%" border="0" cellspacing="10" cellpadding="0">
        <tr>
          <td width="10%" valign="top">
			<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top"><div id="container">
      <h1 class="type"><a href="javascript:void(0)">用户管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="http://www.865171.cn" target="main">用户注册</a></li>
          <li><a href="http://www.865171.cn" target="main">用户列表</a></li>

        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">新闻管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="http://www.865171.cn" target="main">新闻发布</a></li>
          <li><a href="http://www.865171.cn" target="main">新闻列表</a></li>

        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">图片管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="http://www.865171.cn" target="main">图片发布</a></li>
          <li><a href="http://www.865171.cn" target="main">图片列表</a></li>

        </ul>
      </div>
    </div>

      </div>
        <script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
	</script>
        </td>
  </tr>
</table>
          </td>
          <td width="70%" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="8" height="8"><img src="images/index1_28.gif" width="8" height="39" /></td>
                <td width="99%" background="images/index1_40.gif">
                  <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td>
                        <table width="90" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="5"><img src="images/index1_35.gif" width="5" height="39" /></td>
                            <td align="center" background="images/index1_36.gif"><a href="#" class="font3"><strong>编写短信息</strong></a></td>
                            <td width="5"><img src="images/index1_38.gif" width="5" height="39" /></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="80" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="5"><img src="images/index1_29.gif" width="5" height="39" /></td>
                            <td align="center" background="images/index1_30.gif"><a href="#" class="font2"><strong>收件箱</strong></a></td>
                            <td width="5"><img src="images/index1_33.gif" width="5" height="39" /></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                </td>
                <td width="8" height="8"><img src="images/index1_43.gif" width="8" height="39" /></td>
              </tr>
              <tr>
                <td background="images/index1_45.gif"></td>
                <td bgcolor="#FFFFFF" style="height:490px; vertical-align:top;">
                  <table width="100%" border="0" cellspacing="10" cellpadding="0">
                    <tr>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#C4E7FB">
                          <tr>
                            <td>
                              <table width="100%" border="0" cellpadding="0" cellspacing="5" bgcolor="#FFFFFF">
                                <tr>
                                  <td>&nbsp;<a href="#" class="font1">首页</a> &gt; <a href="#" class="font1">信息中心</a> &gt; <a href="#" class="font1"><strong>收件箱</strong></a></td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
                          <tr>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">&nbsp;</td>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">
                              <label>
                              <input type="checkbox" name="checkbox4" value="checkbox" />
                              </label>
                            </td>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">信息标题</td>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">接收公司名称</td>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">接收用户</td>
                            <td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">发送时间</td>
                          </tr>
                          <tr>
                            <td height="26" align="center" bgcolor="#FFFFFF"><img src="images/index1_75.gif" width="16" height="15" /></td>
                            <td height="26" align="center" bgcolor="#FFFFFF">
                              <label>
                              <input type="checkbox" name="checkbox" value="checkbox" />
                              </label>
                            </td>
                            <td height="26" align="center" bgcolor="#FFFFFF">委托人</td>
                            <td height="26" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                            <td height="26" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                            <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
                          </tr>
                          <tr>
                            <td height="26" align="center" bgcolor="#F7FAFF"><img src="images/index1_75.gif" width="16" height="15" /></td>
                            <td height="26" align="center" bgcolor="#F7FAFF">
                              <label>
                              <input type="checkbox" name="checkbox2" value="checkbox" />
                              </label>
                            </td>
                            <td height="26" align="center" bgcolor="#F7FAFF">沃尔</td>
                            <td height="26" align="center" bgcolor="#F7FAFF">&nbsp;</td>
                            <td height="26" align="center" bgcolor="#F7FAFF">&nbsp;</td>
                            <td align="center" bgcolor="#F7FAFF">&nbsp;</td>
                          </tr>
                          <tr>
                            <td height="26" align="center" bgcolor="#FFFFFF"><img src="images/index1_75.gif" width="16" height="15" /></td>
                            <td height="26" align="center" bgcolor="#FFFFFF">
                              <label>
                              <input type="checkbox" name="checkbox3" value="checkbox" />
                              </label>
                            </td>
                            <td height="26" align="center" bgcolor="#FFFFFF">沃尔</td>
                            <td height="26" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                            <td height="26" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                            <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#E1E5E8">
                          <tr>
                            <td>
                              <table width="100%" border="0" cellpadding="0" cellspacing="5" bgcolor="#FDFDFF">
                                <tr>
                                  <td>&nbsp;<img src="images/index1_78.gif" width="16" height="12" align="absmiddle" />&nbsp;已读信息&nbsp;&nbsp;<img src="images/index1_75.gif" width="16" height="15" align="absmiddle" />&nbsp;未读信息</td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                    <tr>
                      <td><a href="#"><img src="images/index1_86.gif" width="74" height="31" border="0" /></a>&nbsp;<a href="#"><img src="images/index1_82.gif" width="74" height="31" border="0" /></a>&nbsp;<a href="#"><img src="images/index1_84.gif" width="74" height="31" border="0" /></a></td>
                    </tr>
                  </table>
                </td>
                <td background="images/index1_47.gif"></td>
              </tr>
              <tr>
                <td width="8" height="8"><img src="images/index1_91.gif" width="8" height="8" /></td>
                <td background="images/index1_92.gif"></td>
                <td width="8" height="8"><img src="images/index1_93.gif" width="8" height="8" /></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</body>
</html>
