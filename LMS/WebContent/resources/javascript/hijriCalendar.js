function hijriDateHandler(innerId,outerId){
var dateHijri = document.getElementById(innerId).value;
console.debug("DATE::"+dateHijri);
selectedValue=dateHijri;
var hiddenHijriDate=document.getElementById(outerId).value = dateHijri;
console.debug("---->>DATE------>>"+hiddenHijriDate);
myJsFunction();
}          
