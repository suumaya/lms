function adjustSelectedHeaderTree() {
	var headerImg1 = document.getElementById('headerImg1Id');
	var headerImg2 = document.getElementById('headerImg2Id');
	var headerImg3 = document.getElementById('headerImg3Id');
	var url = window.location.href;
	var menuType;
	if (url.lastIndexOf("menuType=") == -1) {
		menuType = localStorage.getItem("menuType");
	} else {
		var start = url.lastIndexOf("menuType=") + 9;
		var end = start + 1;
		menuType = url.substring(start, end);
	}
	if (menuType == 1) {
		if (headerImg1 != null)
			headerImg1.className = 'selected-1';
		if (headerImg2 != null)
			headerImg2.className = '';
		if (headerImg3 != null)
			headerImg3.className = '';
	} else if (menuType == 2) {
		if (headerImg1 != null)
			headerImg1.className = '';
		if (headerImg2 != null)
			headerImg2.className = 'selected-2';
		if (headerImg3 != null)
			headerImg3.className = '';
	} else if (menuType == 3) {
		if (headerImg1 != null)
			headerImg1.className = '';
		if (headerImg2 != null)
			headerImg2.className = '';
		if (headerImg3 != null)
			headerImg3.className = 'selected-3';
	}
	localStorage.setItem("menuType", menuType);
}

String.prototype.format = function() {
	var args = arguments;

	return this.replace(/\{(\d+)\}/g, function() {
		return args[arguments[1]];
	});
};

function showErrorMessage(details) {
	PF('notifyMessagesWVId').renderMessage({
		"summary" : "",
		"detail" : details,
		"severity" : "error"
	});
}

/**
 * Get key code from the event
 * 
 * @param event
 * @returns {String}
 */
function getKeyCode(event) {
	var keyCode = '';
	if (window.event) // IE
	{
		keyCode = event.keyCode;
	} else if (event.which) // Net escape/Fire fox/Opera
	{
		keyCode = event.which;
	}
	return keyCode;
}

/**
 * Special operation like copy and paste
 * 
 * @param event
 * @returns {Boolean}
 */
function SpecialOperations(event) {
	var keyCode = getKeyCode(event);
	if (event.ctrlKey === true
			&& (keyCode == 97 || keyCode == 99 || keyCode == 118)) {
		return true;
	}
	return false;
}

function checkDigitWithMaxedLength(event, component, maxLenth) {
	return (checkDigit(event) && enforceMaxLength(component, maxLenth));
}

function checkDigit(event) {
	var keyCode = getKeyCode(event);
	if (keyCode >= 48 && keyCode <= 57) { /* Numbers */
		return true;
	} else {
		if (!SpecialOperations(event)) // check if special operation
		{
			event.preventDefault(); // If it's not a number or a special
			// operation stop the key press
			return false;
		}
	}
	return true;
}

function checkDigitSlash(event) {
	var keyCode = getKeyCode(event);
	if ((keyCode >= 48 && keyCode <= 57) || (keyCode == 47)) { /* Numbers */
		return true;
	} else {
		if (!SpecialOperations(event)) // check if special operation
		{
			event.preventDefault(); // If it's not a number or a special
			// operation stop the key press
			return false;
		}
	}
	return true;
}

function checkLetter(event) {
	var keyCode = getKeyCode(event);
	if ((keyCode >= 97 && keyCode <= 122)
			|| (keyCode >= 1569 && keyCode <= 1610)) { /* Letters */
		return true;
	} else {
		if (!SpecialOperations(event)) // check if special operation
		{
			event.preventDefault(); // If it's not a number or a special
			// operation stop the key press
			return false;
		}
	}
	return true;
}

function checkPhoneNumber(event) {
	var keycode = getKeyCode(event);
	if (keycode == 43) {
		return true;
	}
	return checkDigit(event);
}

function checkCoordinate(event) {
	var keyCode = getKeyCode(event);
	if (keyCode == 176) {
		return true;
	}
	return checkFloat(event);
}

function checkFloat(event) {
	var keyCode = getKeyCode(event);
	if ((keyCode >= 48 && keyCode <= 57) || keyCode == 46) { /* Numbers */
		return true;
	} else {
		if (!SpecialOperations(event)) // check if special operation
		{
			event.preventDefault(); // If it's not a number or a special
			// operation stop the key press
			return false;
		}
	}
	return true;
}

function enforceMaxLength(element, maxLength) {
	if (element != null)
		return (element.value.length < maxLength);
}

function enforceSocialNumber(event, element) {
	var socialNumMaxLen = 12;
	return (checkDigit(event) && enforceMaxLength(element, socialNumMaxLen));
}

/**
 * Check if passed value is a digit or a float else empty the value.
 * 
 * @param component
 * @param type
 * @returns {Boolean}
 */
function isDigitFloat(component, type) {
	// If undefined then its digit
	var regexPattern = type === undefined ? /^\d+/ : /^\d+\.?\d+$/;
	if (!regexPattern.test(component.value)) {
		component.value = "";
		return false;
	}
	return true;
}

/**
 * Check phone number
 * 
 * @param component
 * @param numberLength
 * @returns {Boolean}
 */
function isPhoneNumber(component) {
	var regexPattern = /^\+?(\d)+$/;
	if (!regexPattern.test(component.value)) {
		component.value = "";
		return false;
	}
	return true;
}

/**
 * Validate Max Length
 * 
 * @param component
 * @param length
 * @returns {Boolean}
 */
function valdiateMaxLength(component, length) {
	if (component.value.length > length) {
		return false;
	}
	return true;
}

/**
 * Is Validate Max Length
 * 
 * @param component
 * @param length
 * @returns {Boolean}
 */
function isValdiateMaxLength(component, length) {
	if (component.value.length > length) {
		component.value = component.value.substring(1, length);
		return false;
	}
	return true;
}

function hijriDateOnChange(curId, nullable) {
	if (nullable) {
		var pId = curId.substring(0, curId.lastIndexOf(':') + 1);
		if (document.getElementById(curId).value == '0') {
			document.getElementById(pId + 'day').value = '0';
			document.getElementById(pId + 'month').value = '0';
			document.getElementById(pId + 'year').value = '0';
		} else {
			if (document.getElementById(pId + 'day').value == '0')
				document.getElementById(pId + 'day').value = '01';
			if (document.getElementById(pId + 'month').value == '0')
				document.getElementById(pId + 'month').value = '01';
			if (document.getElementById(pId + 'year').value == '0')
				document.getElementById(pId + 'year').value = '1425';
		}
	}
}

function controlMenuDiv(menuDivId) {
	var menuDiv = document.getElementById(menuDivId);
	var menuDivPlusMenus = document.getElementById(menuDivId + '_PlusMinus');
	if (menuDiv.style.display == 'none') {
		menuDiv.style.display = '';
		menuDivPlusMenus.src = menuDivPlusMenus.src.replace('Plus', 'Minus');
	} else {
		menuDiv.style.display = 'none';
		menuDivPlusMenus.src = menuDivPlusMenus.src.replace('Minus', 'Plus');
	}
}

function controlDiv(divId, displayMode) {
	if (displayMode != null) {
		document.getElementById(divId).style.display = displayMode;
		return;
	}

	var div = document.getElementById(divId);
	if (div.style.display == 'none') {
		div.style.display = '';
	} else {
		div.style.display = 'none';
	}
}

function controlPrevTasks(refuseRoles) {
	for (var i = 0;; i++) {
		try {
			var role = document.getElementById('prevTasks:taskRoleId:' + i).value
					+ ',';
			if (refuseRoles.indexOf(role) > -1)
				document.getElementById('prevTasks:refuseReasonsId:' + i).style.display = '';
			else
				document.getElementById('prevTasks:refuseReasonsId:' + i).style.display = 'none';
		} catch (exception) {
			break;
		}
	}
}

// Calculate current time
function startTime() {
	var timeSectionElm = document.getElementById('timeSection');
	if (timeSectionElm != null) {
		var today = new Date();
		var h = today.getHours();
		var m = today.getMinutes();
		var s = today.getSeconds();
		m = checkTime(m);
		s = checkTime(s);

		timeSectionElm.innerHTML = h + ":" + m + ":" + s;
		var t = setTimeout(startTime, 500);
	}
}
function checkTime(i) {
	if (i < 10) {
		i = "0" + i
	}
	; // add zero in front of numbers < 10
	return i;
}

// ---------------------------------------------------------------------------------------------------------------------

function handleOnAction(confirmMessage, okMethod, cancelMethod) {

	if (confirmMessage != null) {
		if (confirm(confirmMessage)) {
			if (okMethod != null && !eval('(' + okMethod + ')')) {
				return false;
			}
		} else {
			if (cancelMethod != null)
				eval('(' + cancelMethod + ')');
			return false;
		}
	}
	return true;
}

// ---------------------------------------------------------------------------------------------------------------------
// mode: 0 refuse is mandatory - 1 & 2 refuse must be empty - 2 notes mandatory
function validateRefuseAndNotes(mode, refuseId, notesId) {
	var refuse = null;

	if (mode == 0) {
		refuse = document.getElementById(refuseId).value;
		if (refuse == null || refuse == '') {
			alert(document.getElementById('refuseReasonsManadatoryId').value);
			return false;
		}
	} else {
		if (mode == 1 || (mode == 2 && refuseId != null)) {
			refuse = document.getElementById(refuseId).value;
			if (refuse != null && refuse != '') {
				alert(document.getElementById('refuseReasonsEmptyId').value);
				return false;
			}
		}

		if (mode == 2) {
			var notes = document.getElementById(notesId).value;
			if (notes == null || notes == '') {
				alert(document.getElementById('notesManadatoryId').value);
				return false;
			}
		}
	}

	return true;
}

function validateEmpSelection(empsId) {
	if (document.getElementById(empsId).value == 0) {
		alert(document.getElementById('empSelectionManadatoryId').value);
		return false;
	}

	return true;
}
// ---------------------------------------------------------------------------------------------------------------------
var oldSelectedRow = null;
function changeSelectedRowStyle(selectedRow) {
	if (oldSelectedRow != null) {
		oldSelectedRow.style.backgroundColor = '';
	}
	selectedRow.style.backgroundColor = '#96B39B';
	oldSelectedRow = selectedRow;
}

function changeRowOverStyle(overRow) {
	if (oldSelectedRow == null || overRow.id != oldSelectedRow.id)
		overRow.style.backgroundColor = '#E3E3E3';
}

function resetRowOverStyle(overRow) {
	if (oldSelectedRow == null || overRow.id != oldSelectedRow.id)
		overRow.style.backgroundColor = '';
}
// ---------------------------------------------------------------------------------------------------------------------
function getSelectOneRadioValue(radioId) {
	for (var i = 0;; i++) {
		try {
			if (document.getElementById(radioId + ':' + i).checked == true)
				return document.getElementById(radioId + ':' + i).value;
		} catch (exception) {
			break;
		}
	}
	return null;
}

function openPopUpWindow(url) {
	window.open(url);
}

function openSurveillanceOrderView(contextPath, id) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/Surveillance/SurveillanceOrderView.jsf?id='
			+ id, null, strDialogOptions);
}

function openEmployeeAssignmentView(contextPath, mode) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/Assignment/EmployeeAssignmentView.jsf?mode='
			+ mode, null, strDialogOptions);
}

function openNonEmployeeAssignmentView(contextPath, mode) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath
			+ '/Assignment/NonEmployeesAssignmentView.jsf?mode=' + mode, null,
			strDialogOptions);
}

function openEmpsMiniSearchMultipleSelection(contextPath, mode, selectedIds,
		depsList) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/EmpsMiniSearch.jsf?mode=' + mode
			+ "&multiple=" + true + "&ids=" + selectedIds + "&depsList="
			+ depsList, null, strDialogOptions);
}

function openEmpsMiniSearch(contextPath, mode, depsList, selectedIds) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/EmpsMiniSearch.jsf?mode=' + mode
			+ "&depsList=" + depsList + "&ids=" + selectedIds, 'EmpMinisearch',
			strDialogOptions);
}

function openInsertReferralMiniSearch(contextPath) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/InsertReferralMiniSearch.jsf',
			'ReferralMinisearch', strDialogOptions);
}

function openExternalSidesMiniSearch(contextPath) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=500px,dialogHeight=200px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/ExternalSidesMiniSearch.jsf','ExternalSidesMinisearch',strDialogOptions);
}

function openReminderMiniSearch(contextPath) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/ReminderMiniSearch.jsf',
			'ReminderMinisearch', strDialogOptions);
}

function openConversationPartiesMiniSearch(contextPath) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/ConversationPartyMiniSearch.jsf',
			'ConversationParty', strDialogOptions);
}

function openNonEmpsMiniSearch(contextPath, mode) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/NonEmpsMiniSearch.jsf?mode=' + mode,
			null, strDialogOptions);
}

function openDepartmentsMiniSearch(contextPath, mode, regionId,
		departmentTypesList) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/DepartmentsMiniSearch.jsf?mode='
			+ mode + '&departmentTypesList=' + departmentTypesList
			+ '&regionId=' + regionId, null, strDialogOptions);
}

function openNetworksMiniSearch(contextPath) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/NetworkMiniSearch.jsf', null,
			strDialogOptions);
}

function openDomainsMiniSearch(contextPath, mode, classesCodeList) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/DomainsMiniSearch.jsf?mode=' + mode
			+ '&classesCodeList=' + classesCodeList, null, strDialogOptions);
}

function openCountriesMiniSearch(contextPath, mode) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/CountriesMiniSearch.jsf?mode='
			+ mode, null, strDialogOptions);
}

function openOpenSourcesMiniSearch(contextPath, mode) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/OpenSourcesMiniSearch.jsf?mode='
			+ mode, null, strDialogOptions);
}

function openFollowUpResultsMiniSearch(contextPath, followUpId) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath
			+ '/MiniSearch/FollowUpResultMiniSearch.jsf?followUpId='
			+ followUpId, null, strDialogOptions);
}

function openCarPermitsMiniSearch(contextPath, empNonEmpFlag, empNonEmpId) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,width=800px,height=640px,left=250px,top=20px,help=no';
	maskScreen();
	window.open(contextPath
			+ '/MiniSearch/CarPermitsMiniSearch.jsf?empNonEmpFlag='
			+ empNonEmpFlag + '&empNonEmpId=' + empNonEmpId, null,
			strDialogOptions);
}

function openAssignmentsMiniSearch(contextPath, mode) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/AssignmentsMiniSearch.jsf?mode='
			+ mode, null, strDialogOptions);
}

function openAssignmentsMiniSearch(contextPath, mode, regionId) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/AssignmentsMiniSearch.jsf?mode='
			+ mode + '&regionId=' + regionId, null, strDialogOptions);
}

function openSurveillanceEmployeeDetails(contextPath, mode, empId, nonEmpId) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath
			+ '/Surveillance/SurveillanceEmployeeDetails.jsf?mode=' + mode
			+ "&empId=" + empId + "&nonEmpId=" + nonEmpId, null,
			strDialogOptions);
}

function openEmployeeSurveillanceReport(contextPath, mode) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath
			+ '/Surveillance/EmployeeSurveillanceReport.jsf?mode=' + mode,
			null, strDialogOptions);
}

function openConversationsMiniSearch(contextPath, followUpId) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/ConversationMiniSearch.jsf?followUpId=' + followUpId, 'ConversationMiniSearch', strDialogOptions);
}

function openFollowUpMiniSearch(contextPath, isActive) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/FollowUpMiniSearch.jsf?isActive='
			+ isActive, 'FollowUpMiniSearch', strDialogOptions);
}
function openLetterMiniSearch(contextPath, followUpId) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/LetterMiniSearch.jsf?followUpId='
			+ followUpId, null, strDialogOptions);
}

function openCommunicationNodesMiniSearch(contextPath, Id, mode) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	if (mode == 1)
		window.open(contextPath
				+ '/MiniSearch/CommunicationNodes.jsf?followUpId=' + Id
				+ '&mode=' + mode, null, strDialogOptions);
	else
		window.open(contextPath
				+ '/MiniSearch/CommunicationNodes.jsf?networkId=' + Id
				+ '&mode=' + mode, null, strDialogOptions);

}

function openInfoMiniSearch(contextPath, mode, param1, param2, saveDate) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=700px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/InfoMiniSearch.jsf?mode=' + mode
			+ '&param1=' + param1 + '&param2=' + param2 + '&saveDate='
			+ saveDate, null, strDialogOptions);
}

function openEmployeeInfoSysDetailsBySocialId(contextPath, socialId, type,
		saveDate) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/EmployeeInfoSysDetails.jsf?social='
			+ socialId + '&type=' + type + '&saveDate=' + saveDate, null,
			strDialogOptions);
}

function openEmployeeInfoSysDetails(contextPath, mode, type, saveDate) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/EmployeeInfoSysDetails.jsf?mode='
			+ mode + '&type=' + type + '&saveDate=' + saveDate, null,
			strDialogOptions);
}

function openMonthlyRewardPaymentDetails(contextPath, mode, regionId, month,
		hijriYear) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/Finance/MonthlyRewardPaymentDetail.jsf?mode='
			+ mode + '&regionId=' + regionId + '&month=' + month
			+ '&hijriYear=' + hijriYear, null, strDialogOptions);
}

function openWorkflowRepresentation(contextPath, mode, instanceId) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/WorkList/WFRepresentation.jsf?mode=' + mode
			+ '&id=' + instanceId, null, strDialogOptions);
}

function openLabCheckMiniSearch(contextPath) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	maskScreen();
	window.open(contextPath + '/MiniSearch/LabCheckMiniSearch.jsf', null,
			strDialogOptions);
}
// Utility function to open Upload page
function openUploadFile(url, param) {
	strDialogOptions = 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	window.open(url + param, null, strDialogOptions);
}

// Utility function to open Download page
function openDownloadFile(url, param) {
	// strDialogOptions =
	// 'scrollbars=yes,resizable=yes,center=yes,dialogWidth=900px,dialogHeight=500px,help=no';
	window.open(url + param, '_blank');
}
// Validate time format
function valdiateTime(event, elemntId) {
	var regexPattern = /^([01]?[0-9]|2[0-3]):[0-5][0-9]$/;
	if (!regexPattern.test(document.getElementById(elemntId).value)) {
		document.getElementById(elemntId).value = "";
		return false;
	}
}