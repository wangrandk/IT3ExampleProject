async function opretGiraf(){
    let girafform = document.getElementById("girafform");
    let formData = new FormData(girafform)
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
    let result = await fetch("rest/patients");
    console.log(result.status)
    if (result.status!=200){
        alert("noget gik galt!");
    }
    let json = await result.json();
    console.log(json)
    updateGiraffes(json)

}

function updateGiraffes(json) {
    let listelements =""
    json.forEach(function(element){
        listelements += ("<li>"+element.name+"</li>")
    })

    let girafList = document.getElementById("giraffer");
    girafList.innerHTML=listelements
}