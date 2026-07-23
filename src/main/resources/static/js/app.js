const params =
        new URLSearchParams(
                window.location.search);

const token =
        params.get("token");

if (token) {

    localStorage.setItem(
            "jwt",
            token);
}

if (
        !localStorage.getItem(
                "jwt")) {

    window.location.href =
            "/oauth2/authorization/google";
}

const unit1 =
        document.getElementById(
                "unit1");

const unit2 =
        document.getElementById(
                "unit2");

const result =
        document.getElementById(
                "result");

let currentType =
        "length";

let currentAction =
        "compare";

window.onload =
        function () {

            loadLength();
        };

		function setAction(
		        action,
		        button){

		    currentAction =
		            action;

		    document
		            .querySelectorAll(
		                    ".actions button")
		            .forEach(

		                    btn =>
		                    btn.classList
		                            .remove(
		                                    "active"));

		    button.classList
		            .add(
		                    "active");

		    let secondBox =
		            document
		                    .getElementById(
		                            "secondBox");

		    let value2 =
		            document
		                    .getElementById(
		                            "value2");

		    let label1 =
		            document
		                    .getElementById(
		                            "label1");

		    let label2 =
		            document
		                    .getElementById(
		                            "label2");

		    if(
		            action ===
		            "convert"){

		        label1.innerHTML =
		                "Value";

		        label2.innerHTML =
		                "Target Unit";

		        value2.style.display =
		                "none";
		    }

		    else{

		        label1.innerHTML =
		                "First Quantity";

		        label2.innerHTML =
		                "Second Quantity";

		        value2.style.display =
		                "block";
		    }
		}

function selectType(
        type,
        card) {

    document
            .querySelectorAll(
                    ".card")
            .forEach(
                    c =>
                    c.classList
                            .remove(
                                    "active"));

    card.classList
            .add(
                    "active");

    currentType =
            type;

    if (
            type ===
            "length") {

        loadLength();
    }

    else if (
            type ===
            "weight") {

        loadWeight();
    }

    else if (
            type ===
            "temperature") {

        loadTemperature();
    }

    else {

        loadVolume();
    }
}

function loadLength() {

    let units = `

<option value="FEET">
FEET
</option>

<option value="INCHES">
INCHES
</option>

<option value="CENTIMETERS">
CENTIMETERS
</option>

<option value="YARDS">
YARDS
</option>

`;

    unit1.innerHTML =
            units;

    unit2.innerHTML =
            units;
}

function loadWeight() {

    let units = `

<option value="GRAM">
GRAM
</option>

<option value="KILOGRAM">
KILOGRAM
</option>

`;

    unit1.innerHTML =
            units;

    unit2.innerHTML =
            units;
}

function loadTemperature() {

    let units = `

<option value="CELSIUS">
CELSIUS
</option>

<option value="FAHRENHEIT">
FAHRENHEIT
</option>

`;

    unit1.innerHTML =
            units;

    unit2.innerHTML =
            units;
}

function loadVolume() {

    let units = `

<option value="LITRE">
LITRE
</option>

<option value="MILLILITRE">
MILLILITRE
</option>

<option value="GALLON">
GALLON
</option>

`;

    unit1.innerHTML =
            units;

    unit2.innerHTML =
            units;
}

async function calculate() {

    let value1 =
            document
                    .getElementById(
                            "value1")
                    .value;

    let value2 =
            document
                    .getElementById(
                            "value2")
                    .value;

					if(value1===""){

					    alert(
					            "Enter first value");

					    return;
					}

					if(
					        currentAction!=="convert"
					        &&
					        value2===""){

					    alert(
					            "Enter second value");

					    return;
					}

					let secondValue =
					        currentAction==="convert"
					                ? 0
					                : Number(value2);

					let body = {

					    quantity1: {

					        value:
					                Number(
					                        value1),

					        unit:
					                unit1.value
					    },

					    quantity2: {

					        value:
					                secondValue,

					        unit:
					                unit2.value
					    }
					};

    console.log(
            body);

			let url="";

			if(currentAction==="compare"){

			    url="/api/quantity/compare";
			}

			else if(currentAction==="add"){

			    url="/api/quantity/add";
			}

			else if(currentAction==="convert"){

			    url="/api/quantity/convert";
			}
			else if(currentAction==="subtract"){
			    url="/api/quantity/subtract";
			}

			else if(currentAction==="divide"){
			    url="/api/quantity/divide";
			}

    try {

        let response =
                await fetch(
                        url,
                        {

                            method:
                                    "POST",

                            headers: {

                                "Content-Type":
                                        "application/json",

                               
                            },

                            body:
                                    JSON
                                            .stringify(
                                                    body)
                        });

						let data = await response.text();

						console.log(
						        response.status);

						

        console.log(
                data);

				try{

				    let json =
				            JSON.parse(
				                    data);

				    if(
				            json.value
				            !==
				            undefined){

				        result.innerHTML =
				                json.value
				                +
				                " "
				                +
				                json.unit;
				    }

				    else{

				        result.innerHTML =
				                data;
				    }
				}
				catch{

				    result.innerHTML =
				            data;
				}
    }

    catch (e) {

        console.log(
                e);

        alert(
                "Something went wrong");
    }
}