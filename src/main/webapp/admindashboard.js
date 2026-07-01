/**
 * 
 */


const search = document.getElementById("searchinput");
search.addEventListener("keyup",()=>{
    const filter = search.value.toLowerCase();
    const rows = document.querySelectorAll("tbody tr");
    rows.forEach(row=>{
        const text = row.textContent.toLowerCase();
        row.style.display = text.includes(filter)?"":"none";
    });
});

const addStudentBtn = document.getElementById("addStudentBtn");
const modal = document.getElementById("studentmodal");
const closeBtn = document.getElementById("closeModal");

addStudentBtn.addEventListener("click", () => {
    modal.style.display = "flex";
});

closeBtn.addEventListener("click", () => {
    modal.style.display = "none";
});

window.addEventListener("click", (e) => {
    if (e.target === modal) {
        modal.style.display = "none";
    }
});

setTimeout(() => {
    const msg = document.querySelector(".success-msg, .error-msg");
    if(msg){
        msg.style.display = "none";
    }
}, 3000);
