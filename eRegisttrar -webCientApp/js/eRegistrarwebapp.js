/**
 * mybooksmgmtwebapp.js
 */
"use strict";

// IIFE - Immediate-Invoked Function Expression - Module Pattern
(function() {
    
    function getStudents() {
        fetch("http://localhost:8088/eregistrar/api/student/list")
            .then((response) => {
                if(response.ok) {
                    return response.json();
                } else {
                    console.log({status: response.status, statusText: response.statusText});
                    return Promise.reject({status: response.status, statusText: response.statusText});
                }
            })
            .then(students => {
                let content = "";
                students.forEach((student, i) => {
                    if(student.enrollmentDate == null) {
                        content += `
                            <tr>
                                <th scope="row">${i+1}.</th>
                                <td>${student.studentNumber}</td>
                                <td>${student.firstName}</td>
                                <td>${student.middleName}</td>
                                <td>${student.lastName}</td>
                                <td>${student.cgpa}</td>                         
                               
                        `;
                    } else {
                        content += `
                        <tr>
                            <th scope="row">${i+1}.</th>
                            <td>${student.firstName}</td>
                            <td></td>
                    `;
                    }
                });
                document.querySelector("#tbodyStudentsList").innerHTML = content;
            })
            .catch(err => {
                console.log(err);
                const errorMsg = "<tr><td align='center' colspan='3'><p style='color: red;'>We are sorry. The Students WebAPI is unavailable. Please try again later</p></td></tr>";
                document.querySelector("#tbodyStudentsList").innerHTML = errorMsg;
            })
    }
    getStudents();

})();