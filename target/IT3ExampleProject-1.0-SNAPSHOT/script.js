async function opretGiraf(){
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
    await hentGiraffer();
}

async function hentGiraffer(){
    let result = await fetch("rest/patients")
    console.log(result.status)
    if (result.status!=200){
        alert("noget gik galt!");
    }
    let json = await result.json();
    console.log(json)
    updateGiraffes(json)
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
    await hentGiraffer();

}
function updateGiraffes(json) {
    let listelements =""
    json.forEach(function(e){
        listelements += ("<li>"+e+"</li>")
    })

    let girafList = document.getElementById("patient");
    girafList.innerHTML=listelements
}