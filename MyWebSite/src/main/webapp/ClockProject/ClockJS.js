function clock(){
    let d = new Date();
    let d1 = d.getDate();
    let m1 = d.getMonth() + 1;
    let y = d.getFullYear();
    let h = d.getHours();
    let m = d.getMinutes();
    let s = d.getSeconds();
    let status = "AM";
    if (h==0){
        h=12;
    }
    if (h>12){
        h -= 12;
        status = "PM";
    }
    h = (h<10)? "0" + h : h;
    m = (m<10)? "0" + m : m;
    s = (s<10)? "0" + s : s;
    d1 = (d1<10)? "0" + d1 : d1;
    m1 = (m1<10)? "0" + m1 : m1;
    let te = h + " : " + m + " : " + s + " " + status;
    let dt = d1 + " / " + m1 + " / " + y;
    //console.log(te);
    //console.log(dt);
    document.getElementById("displayDate").innerHTML=dt;
    document.getElementById("displayTime").innerHTML=te;
    setTimeout(clock, 1000);
}
clock();