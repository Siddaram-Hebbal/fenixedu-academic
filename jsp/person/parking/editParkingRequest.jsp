<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html:xhtml />
<%@ taglib uri="/WEB-INF/fenix-renderers.tld" prefix="fr"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="net.sourceforge.fenixedu.presentationTier.Action.sop.utils.SessionConstants"%>

<script language="Javascript" type="text/javascript">
<!--

function hide2ndPartForms(){

	if(document.getElementById('ownCar1radio1').checked==true){
		document.getElementById('ownCar1').style.display='none';
	}
	if(document.getElementById('ownCar2radio1').checked==true){
		document.getElementById('ownCar2').style.display='none';
	}
}

function changeElementDisplay(elementId, elementDisplay, topDisplay){
		document.getElementById(elementId).style.display=elementDisplay;
		document.getElementById(elementId+'Top').style.display=topDisplay;
}

function hideInputBoxes(){
	document.getElementById('driverLicenseDiv').style.display='none';
	document.getElementById('driverLicenseDivTop').style.display='block';
	document.getElementById('registry1Div').style.display='none';
	document.getElementById('registry1DivTop').style.display='block';
	document.getElementById('insurance1Div').style.display='none';
	document.getElementById('insurance1DivTop').style.display='block';
	document.getElementById('Id1Div').style.display='none';
	document.getElementById('Id1DivTop').style.display='block';
	document.getElementById('declaration1Div').style.display='none';
	document.getElementById('declaration1DivTop').style.display='block';
	document.getElementById('registry2Div').style.display='none';
	document.getElementById('registry2DivTop').style.display='block';
	document.getElementById('insurance2Div').style.display='none';
	document.getElementById('insurance2DivTop').style.display='block';
	document.getElementById('Id2Div').style.display='none';
	document.getElementById('Id2DivTop').style.display='block';
	document.getElementById('declaration2Div').style.display='none';
	document.getElementById('declaration2DivTop').style.display='block';
}
// -->
</script>


<em><bean:message key="label.person.main.title" /></em>
<h2><bean:message key="label.parking" bundle="PARKING_RESOURCES" /></h2>

<div class="warning0">
	<p class="mvert025"><bean:message key="title.regulation" bundle="PARKING_RESOURCES"/>:</p>
	<ul>
		<li><bean:message key="label.driverLicense" bundle="PARKING_RESOURCES"/></li>
		
		<li><bean:message key="title.forEachVehicle" bundle="PARKING_RESOURCES"/>
			<ul>
				<li><bean:message key="title.registo" bundle="PARKING_RESOURCES"/></li>
				<li><bean:message key="title.insurance" bundle="PARKING_RESOURCES"/></li>
			</ul>
			<li><bean:message key="title.forEachVehicleNotOwned" bundle="PARKING_RESOURCES"/>
			<ul>
				<li><bean:message key="title.ownerId" bundle="PARKING_RESOURCES"/></li>
				<li><bean:message key="title.anexIV" bundle="PARKING_RESOURCES"/></li>
			</ul>
		</li>
	</ul>
	<p class="mvert025"><bean:message key="title.documentDelivery" bundle="PARKING_RESOURCES"/>:</p>
	<ul>
		<li><bean:message key="title.documentDeliveryOnline" bundle="PARKING_RESOURCES"/></li>
		<li><bean:message key="title.documentDeliveryPaper" bundle="PARKING_RESOURCES"/></li>
	</ul>
	<p class="mvert025">Para submeter os documentos necess�rios:</p>
	<ul>
		<li>os ficheiros n�o podem exceder os 2MB de tamanho</li>
		<li>os ficheiros t�m de ser imagens no formato gif ou jpg</li>
		<li>escreva o caminho completo na caixa de texto (ex: <i>c:\documentos\carta_condu��o.jpg</i>)	ou carregue em <i>Browse</i> 
			e escolha o documento correspondente</li>
	</ul>
</div>	

<logic:present name="parkingParty">

	<bean:define id="submit">
		<bean:message key="button.submit" bundle="PARKING_RESOURCES" />
	</bean:define>
	<bean:define id="driverLicenseLabel">
		<bean:message  key="label.driverLicense" bundle="PARKING_RESOURCES"/>
	</bean:define>
	<bean:define id="propertyRegisterLabel">
		<bean:message  key="title.registo" bundle="PARKING_RESOURCES"/>
	</bean:define>
	<bean:define id="insuranceLabel">
		<bean:message  key="title.insurance" bundle="PARKING_RESOURCES"/>
	</bean:define>
	<bean:define id="ownerId">
		<bean:message  key="title.ownerId" bundle="PARKING_RESOURCES"/>
	</bean:define>
	<bean:define id="authorizationDeclaration">
		<bean:message  key="label.firstDeclarationAuthorization" bundle="PARKING_RESOURCES"/>
	</bean:define>
	
	<bean:define id="method" value="createParkingRequest"/>
	<bean:define id="action" value="create"/>
	<bean:define id="factoryName" value="parkingRequestFactoryCreator"/>
	<bean:define id="type" value="net.sourceforge.fenixedu.domain.parking.ParkingRequest$ParkingRequestFactoryCreator"/>

	<logic:notEmpty name="parkingParty" property="parkingRequests">
		<bean:define id="method" value="editParkingRequest"/>
		<bean:define id="action" value="edit"/>
		<bean:define id="factoryName" value="parkingRequestFactoryEditor"/>
		<bean:define id="type" value="net.sourceforge.fenixedu.domain.parking.ParkingRequest$ParkingRequestFactoryEditor"/>
	</logic:notEmpty>

	

	<fr:form action="<%= "/parking.do?method="+method%>" encoding="multipart/form-data">
	<p class="mbottom0"><strong><bean:message key="label.driverLicense" bundle="PARKING_RESOURCES" /></strong>:</p>	
		<table class="tstyle1 thright thlight mbottom0 tstylepark">
		<tr>
			<th class="parking"><div id="driverLicenseDivTop" style="display:none"><bean:message key="label.driverLicense" bundle="PARKING_RESOURCES"/>:</div></th>
			<td class="parking">
				<html:radio name="parkingForm" property="driverLicense" value="true" onclick="changeElementDisplay('driverLicenseDiv', 'none', 'block')">
					<bean:message key="label.deliveredDocument" bundle="PARKING_RESOURCES" arg0="<%=driverLicenseLabel%>"/>
				</html:radio>
				<br/>
				<html:radio name="parkingForm" property="driverLicense" value="false" onclick="changeElementDisplay('driverLicenseDiv', 'block', 'none')">
					<bean:message key="label.deliverOnlineDocument" bundle="PARKING_RESOURCES" arg0="<%=driverLicenseLabel%>"/>
				</html:radio>
			</td>
		</tr>
		</table>
			<div id="driverLicenseDiv">
				<fr:edit id="driverLicenseFR" name="<%= factoryName %>" schema="<%= action+".parkingRequestFactory.driverLicense"%>"
					type="<%= type %>">
					<fr:layout name="tabular">
						<fr:property name="classes" value="tstyle1 thright thlight mtop0 mbottom0 tstylepark"/>
						<fr:property name="columnClasses" value=",parking,noborder"/>
					</fr:layout>
				</fr:edit>
				<span class="error0 mtop0"><html:messages id="message" property="driverLicenseMessage" message="true" bundle="PARKING_RESOURCES">
					<bean:write name="message"/><br/>
				</html:messages></span>
			</div>
			<br/>
			
	<!-- FIRST CAR BEGINING -->
	<p class="mbottom0"><strong><bean:message key="label.firstCar" bundle="PARKING_RESOURCES" /></strong>:</p>
		<table class="tstyle1 thright thlight mtop025 mbottom0 tstylepark">
		<tr>
			<th class="parking"><bean:message key="label.firstCarMake" bundle="PARKING_RESOURCES"/>:</th>
			<td class="parking"><fr:edit id="firstCarMakeFR" name="<%= factoryName %>" slot="firstCarMake" 
				type="<%= type %>">
			</fr:edit></td>
			<td class="noborder"><span class="error0 mtop025">
				<html:messages id="message" property="firstCarMakePT" message="true" bundle="PARKING_RESOURCES">
					<bean:write name="message"/><br/>
				</html:messages></span>
			</td>
		</tr>
		<tr>
			<th class="parking"><bean:message key="label.firstCarPlateNumber" bundle="PARKING_RESOURCES"/>:</th>
			<td class="parking"><fr:edit id="firstCarPlateNumberFR" name="<%= factoryName %>" slot="firstCarPlateNumber"
				type="<%= type %>">
			</fr:edit> (aa-bb-cc)</td>
			<td class="noborder"><span class="error0 mtop025">
				<html:messages id="message" property="firstCarPlateNumberPT" message="true" bundle="PARKING_RESOURCES">
					<bean:write name="message"/><br/></span>
				</html:messages>
			</td>
		</tr>
		<tr>
			<th class="parking"><div id="registry1DivTop" style="display:none"><bean:message key="label.firstCarPropertyRegistry" bundle="PARKING_RESOURCES"/>:</div></th>
			<td class="parking">
				<html:radio name="parkingForm" property="registry1" value="true" onclick="changeElementDisplay('registry1Div', 'none', 'block')">
					<bean:message key="label.deliveredDocument" bundle="PARKING_RESOURCES" arg0="<%=propertyRegisterLabel%>"/>
				</html:radio>
				<br/>
				<html:radio name="parkingForm" property="registry1" value="false" onclick="changeElementDisplay('registry1Div', 'block', 'none')">
					<bean:message key="label.deliverOnlineDocument" bundle="PARKING_RESOURCES" arg0="<%=propertyRegisterLabel%>"/>
				</html:radio>
			</td>	
		</tr>
		</table>

			<div id="registry1Div">
				<fr:edit id="registry1FR" name="<%= factoryName %>"  schema="<%= action+".parkingRequestFactory.firstCarRegistry"%>"
					type="<%= type %>">
					<fr:layout name="tabular">
						<fr:property name="classes" value="tstyle1 thright thlight mtop0 mbottom0 tstylepark"/>
						<fr:property name="columnClasses" value=",parking,noborder"/>
					</fr:layout>
				</fr:edit>
				<span class="error0 mtop025"><html:messages id="message" property="firstCarPropertyRegistryMessage" message="true" bundle="PARKING_RESOURCES">
					<bean:write name="message"/><br/>
				</html:messages></span>				
			</div>
			
		<table class="tstyle1 thright thlight mtop0 mbottom0 tstylepark">
		<tr>
			<th class="parking"><div id="insurance1DivTop" style="display:none"><bean:message key="label.firstInsurance" bundle="PARKING_RESOURCES"/>:</div></th>
			<td class="parking">
				<html:radio name="parkingForm" property="insurance1" value="true" onclick="changeElementDisplay('insurance1Div', 'none', 'block')">
					<bean:message key="label.deliveredDocument" bundle="PARKING_RESOURCES" arg0="<%=insuranceLabel%>"/>
				</html:radio>
				<br/>
				<html:radio name="parkingForm" property="insurance1" value="false" onclick="changeElementDisplay('insurance1Div', 'block', 'none')">
					<bean:message key="label.deliverOnlineDocument" bundle="PARKING_RESOURCES" arg0="<%=insuranceLabel%>"/>
				</html:radio>
			</td>	
		</tr>
		</table>
			<div id="insurance1Div">
				<fr:edit id="insurance1FR" name="<%= factoryName %>" schema="<%= action+".parkingRequestFactory.firstCarInsurance"%>"
					type="<%= type %>">
					<fr:layout name="tabular">
						<fr:property name="classes" value="tstyle1 thright thlight mtop0 mbottom0 tstylepark"/>
						<fr:property name="columnClasses" value=",parking,noborder"/>
					</fr:layout>				
				</fr:edit>
				<span class="error0 mtop025"><html:messages id="message" property="firstInsuranceMessage" message="true" bundle="PARKING_RESOURCES">
					<bean:write name="message"/><br/>
				</html:messages></span>
			</div>
			
			
			<p>
				<bean:message key="label.ownVehicle" bundle="PARKING_RESOURCES"/>
				<html:radio styleId="ownCar1radio1" name="parkingForm" property="ownVehicle1" value="true" onclick="document.getElementById('ownCar1').style.display='none'"/>
					<bean:message key="label.yes" bundle="PARKING_RESOURCES"/>
				<html:radio styleId="ownCar1radio2" name="parkingForm" property="ownVehicle1" value="false" onclick="document.getElementById('ownCar1').style.display='block'"/>
					<bean:message key="label.no" bundle="PARKING_RESOURCES"/>				
			</p>
			<div id="ownCar1">
		<table class="tstyle1 thright thlight mtop025 mbottom0 tstylepark">
		<tr>
			<th class="parking"><div id="Id1DivTop" style="display:none"><bean:message key="label.firstCarOwnerId" bundle="PARKING_RESOURCES"/>:</div></th>
			<td class="parking">
				<html:radio name="parkingForm" property="Id1" value="true" onclick="changeElementDisplay('Id1Div', 'none', 'block')">
					<bean:message key="label.deliveredDocument" bundle="PARKING_RESOURCES" arg0="<%=ownerId%>"/>
				</html:radio>
				<br/>
				<html:radio name="parkingForm" property="Id1" value="false" onclick="changeElementDisplay('Id1Div', 'block', 'none')">
					<bean:message key="label.deliverOnlineDocument" bundle="PARKING_RESOURCES" arg0="<%=ownerId%>"/>
				</html:radio>
			</td>	
		</tr>
		</table>
			<div id="Id1Div">
				<fr:edit id="Id1FR" name="<%= factoryName %>" schema="<%= action+".parkingRequestFactory.firstCarId.notOwnCar"%>"
					type="<%= type %>">
					<fr:layout name="tabular">
						<fr:property name="classes" value="tstyle1 thright thlight mtop0 mbottom0 tstylepark"/>
						<fr:property name="columnClasses" value=",parking,noborder"/>
					</fr:layout>					
				</fr:edit>
				<span class="error0 mtop025"><html:messages id="message" property="firstCarOwnerIdMessage" message="true" bundle="PARKING_RESOURCES">
					<bean:write name="message"/><br/>
				</html:messages></span>
			</div>
		<table class="tstyle1 thright thlight mtop0 mbottom0 tstylepark">
		<tr>
			<th class="parking"><div id="declaration1DivTop" style="display:none"><bean:message key="label.firstDeclarationAuthorization" bundle="PARKING_RESOURCES"/>:</div></th>
			<td class="parking">
				<html:radio name="parkingForm" property="declaration1" value="true" onclick="changeElementDisplay('declaration1Div', 'none', 'block')">
					<bean:message key="label.deliveredDocument" bundle="PARKING_RESOURCES" arg0="<%=authorizationDeclaration%>"/>
				</html:radio>
				<br/>
				<html:radio name="parkingForm" property="declaration1" value="false" onclick="changeElementDisplay('declaration1Div', 'block', 'none')">
					<bean:message key="label.deliverOnlineDocument" bundle="PARKING_RESOURCES" arg0="<%=authorizationDeclaration%>"/>
				</html:radio>
			</td>					
		</tr>
		</table>
			<div id="declaration1Div">
				<fr:edit id="declaration1FR" name="<%= factoryName %>" schema="<%= action+".parkingRequestFactory.firstCarAuthorization.notOwnCar"%>"
					type="<%= type %>">
				
					<fr:layout name="tabular">
						<fr:property name="classes" value="tstyle1 thright thlight mtop0 mbottom0 tstylepark"/>
						<fr:property name="columnClasses" value=",parking,noborder"/>
					</fr:layout>				
				</fr:edit>
				<span class="error0 mtop025"><html:messages id="message" property="firstDeclarationAuthorizationMessage" message="true" bundle="PARKING_RESOURCES">
					<bean:write name="message"/><br/>
				</html:messages></span>
			</div>
		
			</div>
			<br/><br/>
					
	<!-- SECOND CAR BEGINING -->
			
<p class="mbottom0"><strong><bean:message key="label.secondCar" bundle="PARKING_RESOURCES" /></strong>:</p>
		<table class="tstyle1 thright thlight mtop025 mbottom0 tstylepark">
		<tr>
			<th class="parking"><bean:message key="label.secondCarMake" bundle="PARKING_RESOURCES"/>:</th>
			<td class="parking"><fr:edit id="secondCarMakeFR" name="<%= factoryName %>" slot="secondCarMake" 
					type="<%= type %>">
			</fr:edit></td>
		</tr>
		<tr>
			<th class="parking"><bean:message key="label.secondCarPlateNumber" bundle="PARKING_RESOURCES"/>:</th>
			<td class="parking"><fr:edit id="secondCarPlateNumberFR" name="<%= factoryName %>" slot="secondCarPlateNumber"
					type="<%= type %>">
			</fr:edit> (aa-bb-cc)</td>			
		</tr>
		<tr>
			<th class="parking"><div id="registry2DivTop" style="display:none"><bean:message key="label.secondCarPropertyRegistry" bundle="PARKING_RESOURCES"/>:</div></th>
			<td class="parking">
				<html:radio name="parkingForm" property="registry2" value="true" onclick="changeElementDisplay('registry2Div', 'none', 'block')">
					<bean:message key="label.deliveredDocument" bundle="PARKING_RESOURCES" arg0="<%=propertyRegisterLabel%>"/>
				</html:radio>
				<br/>
				<html:radio name="parkingForm" property="registry2" value="false" onclick="changeElementDisplay('registry2Div', 'block', 'none')">
					<bean:message key="label.deliverOnlineDocument" bundle="PARKING_RESOURCES" arg0="<%=propertyRegisterLabel%>"/>
				</html:radio>
			</td>	
		</tr>
		</table>

			<div id="registry2Div">
				<fr:edit id="registry2FR" name="<%= factoryName %>" schema="<%= action+".parkingRequestFactory.secondCarRegistry"%>"
					type="<%= type %>">
					<fr:layout name="tabular">
						<fr:property name="classes" value="tstyle1 thright thlight mtop0 mbottom0 tstylepark"/>
						<fr:property name="columnClasses" value=",parking,noborder"/>
					</fr:layout>
				</fr:edit>
				<span class="error0 mtop025"><html:messages id="message" property="secondCarPropertyRegistryMessage" message="true" bundle="PARKING_RESOURCES">
					<bean:write name="message"/><br/><br/>
				</html:messages></span>
			</div>

		<table class="tstyle1 thright thlight mtop0 mbottom0 tstylepark">
		<tr>
			<th class="parking"><div id="insurance2DivTop" style="display:none"><bean:message key="label.secondInsurance" bundle="PARKING_RESOURCES"/>:</div></th>
			<td class="parking">
				<html:radio name="parkingForm" property="insurance2" value="true" onclick="changeElementDisplay('insurance2Div', 'none', 'block')">
					<bean:message key="label.deliveredDocument" bundle="PARKING_RESOURCES" arg0="<%=insuranceLabel%>"/>
				</html:radio>
				<br/>
				<html:radio name="parkingForm" property="insurance2" value="false" onclick="changeElementDisplay('insurance2Div', 'block', 'none')">
					<bean:message key="label.deliverOnlineDocument" bundle="PARKING_RESOURCES" arg0="<%=insuranceLabel%>"/>
				</html:radio>
			</td>	
		</tr>
		</table>
			<div id="insurance2Div">
				<fr:edit id="insurance2FR" name="<%= factoryName %>" schema="<%= action+".parkingRequestFactory.secondCarInsurance"%>"
					type="<%= type %>">
					<fr:layout name="tabular">
						<fr:property name="classes" value="tstyle1 thright thlight mtop0 mbottom0 tstylepark"/>
						<fr:property name="columnClasses" value=",parking,noborder"/>
					</fr:layout>				
				</fr:edit>
				<span class="error0 mtop025"><html:messages id="message" property="secondInsuranceMessage" message="true" bundle="PARKING_RESOURCES">
					<bean:write name="message"/><br/><br/><br/>
				</html:messages></span>
			</div>
			
			
			<p>
				<bean:message key="label.ownVehicle" bundle="PARKING_RESOURCES"/>
				<html:radio styleId="ownCar2radio1" name="parkingForm" property="ownVehicle2" value="true" onclick="document.getElementById('ownCar2').style.display='none'"/>
					<bean:message key="label.yes" bundle="PARKING_RESOURCES"/>
				<html:radio styleId="ownCar2radio2" name="parkingForm" property="ownVehicle2" value="false" onclick="document.getElementById('ownCar2').style.display='block'"/>
					<bean:message key="label.no" bundle="PARKING_RESOURCES"/>	
			</p>
			<div id="ownCar2">
		<table class="tstyle1 thright thlight mtop025 mbottom0 tstylepark">
		<tr>
			<th class="parking"><div id="Id2DivTop" style="display:none"><bean:message key="label.secondCarOwnerId" bundle="PARKING_RESOURCES"/>:</div></th>
			<td class="parking">
				<html:radio name="parkingForm" property="Id2" value="true" onclick="changeElementDisplay('Id2Div', 'none', 'block')">
					<bean:message key="label.deliveredDocument" bundle="PARKING_RESOURCES" arg0="<%=ownerId%>"/>
				</html:radio>
				<br/>
				<html:radio name="parkingForm" property="Id2" value="false" onclick="changeElementDisplay('Id2Div', 'block', 'none')">
					<bean:message key="label.deliverOnlineDocument" bundle="PARKING_RESOURCES" arg0="<%=ownerId%>"/>
				</html:radio>
			</td>	
		</tr>
		</table>
			<div id="Id2Div">
				<fr:edit id="Id2FR" name="<%= factoryName %>" schema="<%= action+".parkingRequestFactory.secondCarId.notOwnCar"%>"
					type="<%= type %>">
					<fr:layout name="tabular">
						<fr:property name="classes" value="tstyle1 thright thlight mtop0 mbottom0 tstylepark"/>
						<fr:property name="columnClasses" value=",parking,noborder"/>
					</fr:layout>					
				</fr:edit>
				<span class="error0 mtop025"><html:messages id="message" property="secondCarOwnerIdMessage" message="true" bundle="PARKING_RESOURCES">
					<bean:write name="message"/><br/><br/>
				</html:messages></span>
			</div>
		<table class="tstyle1 thright thlight mtop0 mbottom0 tstylepark">
		<tr>
			<th class="parking"><div id="declaration2DivTop" style="display:none"><bean:message key="label.firstDeclarationAuthorization" bundle="PARKING_RESOURCES"/>:</div></th>
			<td class="parking">
				<html:radio name="parkingForm" property="declaration2" value="true" onclick="changeElementDisplay('declaration2Div', 'none', 'block')">
					<bean:message key="label.deliveredDocument" bundle="PARKING_RESOURCES" arg0="<%=authorizationDeclaration%>"/>
				</html:radio>
				<br/>
				<html:radio name="parkingForm" property="declaration2" value="false" onclick="changeElementDisplay('declaration2Div', 'block', 'none')">
					<bean:message key="label.deliverOnlineDocument" bundle="PARKING_RESOURCES" arg0="<%=authorizationDeclaration%>"/>
				</html:radio>
			</td>					
		</tr>
		</table>
			<div id="declaration2Div">
				<fr:edit id="declaration2FR" name="<%= factoryName %>" schema="<%= action+".parkingRequestFactory.secondCarAuthorization.notOwnCar"%>"
					type="<%= type %>">
					<fr:layout name="tabular">
						<fr:property name="classes" value="tstyle1 thright thlight mtop0 mbottom0 tstylepark"/>
						<fr:property name="columnClasses" value=",parking,noborder"/>
					</fr:layout>				
				</fr:edit>
				<span class="error0 mtop0"><html:messages id="message" property="secondDeclarationAuthorizationMessage" message="true" bundle="PARKING_RESOURCES">
					<bean:write name="message"/><br/><br/>
				</html:messages></span>
			</div>
		
			</div>
			<br/>
		<input type="submit" value="<%= submit.toString() %>" />		

		</fr:form>

</logic:present>

	<script type="text/javascript">
		hide2ndPartForms();
		hideInputBoxes();
	</script>

