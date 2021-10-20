function customHijriBtnsAction(action, elementId, value) {
	if (action == 'previousYear') {
		document.getElementById(elementId + ':customHijriBtnPreviousYearId').click();
	} else if (action == 'previousMonth') {
		document.getElementById(elementId + ':customHijriBtnPreviousMonthId').click();
	} else if (action == 'nextMonth') {
		document.getElementById(elementId + ':customHijriBtnNextMonthId').click();
	} else if (action == 'nextYear') {
		document.getElementById(elementId + ':customHijriBtnNextYearId').click();
	} else if (action == 'today') {
		document.getElementById(elementId + ':customHijriBtnTodayId').click();
	} else if (action == 'selectDateValue') {
		var currentMonth = document.getElementById(elementId + ':currentMonthId').value;
		currentMonth = currentMonth < 10 ? '0' + currentMonth : currentMonth;
		var currentYear = document.getElementById(elementId + ':currentYearId').value;
		document.getElementById(elementId + ':dateValueIdDay').value = value < 10 ? '0' + value : value;
		document.getElementById(elementId + ':dateValueIdMonth').value = currentMonth;
		document.getElementById(elementId + ':dateValueIdYear').value = currentYear;

		document.getElementById(elementId + ':dateValueId').value = (value < 10 ? '0' + value : value) + '/' + currentMonth + '/' + currentYear;
		document.getElementById(elementId + ':customHijriBtnSelectDateId').click();
	}
}

function dateHandler(elementId) {
	var day = document.getElementById(elementId + ':dateValueIdDay').value;
	var month = document.getElementById(elementId + ':dateValueIdMonth').value;
	var year = document.getElementById(elementId + ':dateValueIdYear').value;

	if (((typeof (day) != 'undefined') && (day != '') && (day.length == 2)) && ((typeof (month) != 'undefined') && (month != '') && (month.length == 2)) && ((typeof (year) != 'undefined') && (year != '') && (year.length > 3))) {

		// console.log("now");
		document.getElementById(elementId + ':dateValueId').value = day + '/' + month + '/' + year;
		document.getElementById(elementId + ':customHijriBtnSelectDateId').click();
	} else if ((day == '') && (month == '') && (year == '')) {
		document.getElementById(elementId + ':dateValueId').value = '';
		document.getElementById(elementId + ':customHijriBtnSelectDateId').click();
	}
}

function dayHandler(event, day, generatedId) {
	var dayNum = parseInt(day);
	deleteHandler(event, generatedId);
	backspaceHandler(event, day, generatedId);
	if (dayNum > 30 || dayNum <= 0) {
		document.getElementById(generatedId + ':dateValueIdDay').value = '';
	} else {
		if (day.length == 2) {
			document.getElementById(generatedId + ':dateValueIdMonth').focus();
			document.getElementById(generatedId + ':dateValueIdMonth').select();
		}
		if (day.length == 1) {
			document.getElementById(generatedId + ':dateValueIdDay').value = '0' + day;
			document.getElementById(generatedId + ':dateValueIdMonth').focus();
			document.getElementById(generatedId + ':dateValueIdMonth').select();
		}
	}
}

function monthHandler(event, month, generatedId) {
	var monthNum = parseInt(month);
	deleteHandler(event, generatedId);
	backspaceHandler(event, month, generatedId);
	if (monthNum > 12 || monthNum <= 0) {
		document.getElementById(generatedId + ':dateValueIdMonth').value = '';
	} else {
		if (month.length == 2) {
			document.getElementById(generatedId + ':dateValueIdYear').focus();
			document.getElementById(generatedId + ':dateValueIdYear').select();
		}
		if (month.length == 1) {
			document.getElementById(generatedId + ':dateValueIdMonth').value = '0' + month;
			document.getElementById(generatedId + ':dateValueIdYear').focus();
			document.getElementById(generatedId + ':dateValueIdYear').select();
		}
	}
}

function yearHandler(event, year, generatedId, birthDateRange) {
	var yearNum = parseInt(year);
	deleteHandler(event, generatedId);
	backspaceHandler(event, year, generatedId);
	var maxYear=1443,minYear=1425;
	if (!birthDateRange && (yearNum > maxYear || yearNum < minYear)) {
		document.getElementById(generatedId + ':dateValueIdYear').value = minYear;
	}
	dateHandler(generatedId);
}

function backspaceHandler(event, value, generatedId) {
	var key = event.keyCode || event.charCode;
	if (key == 8 && value == '') {
		// console.log("backspace");
		document.getElementById(generatedId + ':' + 'dateValueIdYear').value = '';
		document.getElementById(generatedId + ':' + 'dateValueIdMonth').value = '';
		document.getElementById(generatedId + ':' + 'dateValueIdDay').value = '';
		dateHandler(generatedId);
	}
}

function deleteHandler(event, generatedId) {
	var key = event.keyCode || event.charCode;
	if (key == 46) {
		// console.log("Delete");
		document.getElementById(generatedId + ':' + 'dateValueIdYear').value = '';
		document.getElementById(generatedId + ':' + 'dateValueIdMonth').value = '';
		document.getElementById(generatedId + ':' + 'dateValueIdDay').value = '';
		dateHandler(generatedId);
	}
}

$(document).ready(function() {
	$('.custom_text_calendar_New').keypress(function(event) {

		if (event.keyCode >= 48 && event.keyCode <= 57) {
			return;
		} else {
			event.preventDefault();
		}

	});

	$(document).on('click', '.custom_text_calendar_New', function() {
		this.select();
	});

	$(document).on('hover', '.hijriError', function() {
		$(this).fadeOut(1500);
	});

});
