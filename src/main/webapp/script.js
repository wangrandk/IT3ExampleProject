async function CreatePatient(){
    let patientform = document.getElementById("patientform");
    let formData = new FormData(patientform)
    let patientJson = Object.fromEntries(formData);
    let res = await fetch("rest/patients", {
        method:"POST",
        body: JSON.stringify(patientJson),
        headers:{
            'content-type':"application/json"
        }
    })
    alert (res);
    await GetPatient();
}

async function GetPatient(){
    /*fetch("http://localhost:8080/IT3ExampleProject_war/patients")
       .then(resp => resp.json()).then(data => updateGiraffes(data));*/

   let result = await fetch("rest/patients"); //.then(resp => resp.json()).then(data => updateGiraffes(data));

   console.log(result.status)
   if (result.status!=200){
       alert("noget gik galt!");
   }
   let json = await result.json();
   console.log(json)
    //updateGiraffes(json)
}

async function deletePatient(){
    let deleteform = document.getElementById("deleteform");
    let formData = new FormData(deleteform)
    let patientJson = Object.fromEntries(formData);
    let res = await fetch("rest/patients/" + patientJson.cpr, {
        method:"DELETE",
        headers:{
            'content-type':"application/json"
        }
    })
    alert (res);
    await GetPatient();

}
function updateGiraffes(json) {
    console.log(json)
    let listelements =""
    json.forEach(function(e){
        listelements += ("<li>"+e.name + " "+e.cpr+"</li>")
    })

    let girafList = document.getElementById("patient");
    girafList.innerHTML=listelements
}
