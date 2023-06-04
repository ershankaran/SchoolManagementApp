var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);

var chartDataStr2 = decodeHtml(chartData2);
var chartJsonArray2 = JSON.parse(chartDataStr2);



var arrayLength = chartJsonArray.length;
var arrayLength2 = chartJsonArray2.length;

var numericData = [];
var labelData = [];

var numericData2 = [];
var labelData2 = [];

for(var i=0; i < arrayLength; i++){
	numericData[i] = chartJsonArray[i].studentCount;
	labelData[i] = chartJsonArray[i].classroomName;
}

for(var i=0; i < arrayLength2; i++){
	numericData2[i] = chartJsonArray2[i].teacherCount;
	labelData2[i] = chartJsonArray2[i].classroomName;
}

// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'bar',
    // The data for our dataset
    data : {
        labels:labelData,
        datasets: [{
          label: 'Classroom Student Count',
          data: numericData,
          backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(54, 162, 235)',
            'rgb(255, 205, 86)'
          ],
          hoverOffset: 4
        }]
      },

    // Configuration options go here
    options: {
    	title: {
    		display: true,
    		text: 'Classroom Student'        
    	},
      scale: {
        ticks: {
          precision: 0
        }
      }
    	
    }
});


new Chart(document.getElementById("myPieChart2"), {
    type: 'bar',
    // The data for our dataset
    data : {
        labels:labelData2,
        datasets: [{
          label: 'Classroom Teacher Count',
          data: numericData2,
          backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(54, 162, 235)',
            'rgb(255, 205, 86)'
          ],
          hoverOffset: 4
        }]
      },

    // Configuration options go here
    options: {
    	title: {
    		display: true,
    		text: 'Project Statuses'
    	},
      scale: {
        ticks: {
          precision: 0
        }
      }
    	
    }
});

// "[{"value": 1, "label": "COMPLETED"},{"value": 2, "label": "INPROGRESS"},{"value": 1, "label": "NOTSTARTED"}]"
function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}