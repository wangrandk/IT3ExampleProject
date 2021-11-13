async function CreatePatient(){
    let patientform = document.getElementById("patientform");
    let formData = new FormData(patientform);
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
/*
    var mysql = require('mysql');
    var con = mysql.createConnection({
        host: "localhost",
        user: "myusername",
        password: "mypassword",
        database: "mydb"
    });

    con.connect(function(err) {
        if (err) throw err;
        console.log("Connected!");
        //Insert a record in the "customers" table:
        var sql = "INSERT INTO customers (name, address) VALUES ('Company Inc', 'Highway 37')";
        con.query(sql, function (err, result) {
            if (err) throw err;
            console.log("1 record inserted");
        });
    });
 */
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
    updatePatient(json)
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

function updatePatient(json) {
    console.log(json)
    let listelements =""
    json.forEach(function(e){
        listelements += ("<li>"+e.name + " "+e.cpr+"</li>")
    })
    let patientList = document.getElementById("patient");
    patientList.innerHTML=listelements
}
async function insertPatient(){

}
