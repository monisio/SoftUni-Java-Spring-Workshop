const boxAimg = document.getElementById("box-a-img");
const boxTempA = document.getElementById("box-a-temp");
const boxBimg = document.getElementById("box-b-img");
const boxTempB = document.getElementById("box-b-temp");

 fetch("http://api.openweathermap.org/data/2.5/weather?q=Sofia&appid=8dd1b8c6c70655b59ef4f75b4d9fb753")
    .then(data => data.json())
    .then(info => {
        boxTempA.innerText = Math.round(info.main.temp - 273.15);
        boxAimg.src = "/images/weather-icons/" + info.weather[0].icon + ".png"
    });

fetch("http://api.openweathermap.org/data/2.5/weather?q=Sozopol&appid=8dd1b8c6c70655b59ef4f75b4d9fb753")
    .then(data => data.json())
    .then(info => {
        boxTempB.innerText = Math.round(info.main.temp - 273.15);
        boxBimg.src = "/images/weather-icons/" + info.weather[0].icon + ".png"
    });


console.log("HERE")


