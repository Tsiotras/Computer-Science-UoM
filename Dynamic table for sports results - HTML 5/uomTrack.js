var table = document.getElementsByClassName("uomTrack")[0];
var tableRows = table.getElementsByTagName("tr");

var head = table.querySelector("thead");
var tfoot = table.querySelector("tfoot");
var entries = document.querySelector("tbody").querySelectorAll("td")

//TSIOTRAS DIMITRIOS MAI19078

//CSS Style

fixStyle();
editable();
getMinMaxAverage();
addButtons();

head.querySelectorAll("td")[0].onclick= function(){sortTable(0);};
head.querySelectorAll("td")[1].onclick= function(){sortTable(1);};
head.querySelectorAll("td")[2].onclick= function(){sortTable(2);};
head.querySelectorAll("td")[3].onclick= function(){sortTable(3);};

function fixStyle(){   
head.style.fontSize = "x-large";
head.style.fontStyle = "italic";
head.style.color = 'black';


table.style.borderSpacing = "10px";
table.style.color = "grey";
table.style.fontSize = "large";
table.style.fontFamily = "Verdana";

for(i=1; i<table.rows.length; i++)
{	table.rows[i].cells[3].setAttribute("class", "timescell");

	table.rows[i].insertCell(table.rows[i].cells.length);
	table.rows[i].cells[4].setAttribute("class", "copycell");
		table.rows[i].insertCell(table.rows[i].cells.length);
		table.rows[i].cells[5].setAttribute("class", "deletecell");
}
}

function editable(){

for(var i=1; i< table.rows.length; i++)
{
	for(var n=0; n<table.rows[i].cells.length - 2; n++){
table.rows[i].getElementsByTagName("td")[n].contentEditable = "true";
table.rows[i].getElementsByTagName("td")[n].style.border = "solid";

	}
}
}


function getMinMaxAverage(){	
	var sum = 0;
	var best = 0 ;
    var worst = 0;
	var avg = 0 ; 
	var count = 0;

for(var i=1; i< tableRows.length; i++)
{
	if(i==1){
		worst = table.rows[i].cells[3].innerHTML;
		worstIndex = table.rows[i].rowIndex;
		best = table.rows[i].cells[3].innerHTML;
		bestIndex = table.rows[i].rowIndex;
	}
	else if(worst > table.rows[i].cells[3].innerHTML)
	{	

		worst = table.rows[i].cells[3].innerHTML;

		worstIndex = table.rows[i].rowIndex;
	}
	else if(best < table.rows[i].cells[3].innerHTML)
	{
		best = table.rows[i].cells[3].innerHTML;
		bestIndex = table.rows[i].rowIndex;
	}
	sum= sum + Number(table.rows[i].cells[3].innerHTML);
	count++;

}
	avg = sum/count;
	tfoot.textContent = "Best: " +best + " Worst: " +worst+ " Average: " +avg ;
}


//BUTTONS 


function addButtons(){


	for(var i=1; i<tableRows.length; i++)
	{

		var x = document.createElement("BUTTON");
		x.innerHTML = "Copy";
		x.setAttribute("class", "copyBtn");
		table.rows[i].cells[4].appendChild(x);


		var y = document.createElement("BUTTON");
		y.innerHTML= "Delete";
		y.setAttribute("class", "deleteBtn");
		table.rows[i].cells[5].appendChild(y);

	}


}

//for update 

window.onclick = function(){
getMinMaxAverage();
for(var i=0; i<tableRows.length; i++)
	{
		table.getElementsByClassName("copyBtn")[i].onclick = function(){
	   var td = event.target.parentNode; 
      var tr = td.parentNode; 
		var node = tr.cloneNode(true)
		table.appendChild(node);
		getMinMaxAverage();
		};

		table.getElementsByClassName("deleteBtn")[i].addEventListener("click", function(){
      var td = event.target.parentNode; 
      var tr = td.parentNode; 
      if(tableRows.length > 2)
      tr.parentNode.removeChild(tr);
  	getMinMaxAverage();});
	}
	}

//sort table based on the column
 function sortTable(n) {
  var  switching, i, x, y, shouldSwitch, dir, switchcount = 0;

  switching = true;

  dir = "asc"; 
  while (switching) {
    switching = false;
    

    for (i = 1; i < (tableRows.length - 1); i++) {
      
      shouldSwitch = false;
      
      x = table.rows[i].cells[n];
      y = table.rows[i + 1].cells[n];

      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          shouldSwitch = true;
          break;
        }
      }
    }
    if (shouldSwitch) {

      tableRows[i].parentNode.insertBefore(tableRows[i + 1], tableRows[i]);
      switching = true;

      switchcount ++; 
    } else {
     
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}

