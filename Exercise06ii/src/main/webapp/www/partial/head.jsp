<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MeTube v1</title>
<style>

    /* sticky footer - start */
    html, body {
        height: 100%;
        margin: 0;
    }
    .wrapper {
        min-height: 100%;
        margin-bottom: -80px;
    }
    .footer,
    .push {
        height: 80px;
    }
    /* sticky footer - end */

    body {
        background-color: rgb(233, 236, 239);
        font-family: Verdana, sans-serif;
    }
    h1 {
        font-weight: 400;
        text-align: center;
        padding: 10px;
    }
    hr.style1 {
        border: 1px double darkgray;
        margin: 0 25px 0 25px;
    }
    .button {
        border: none;
        border-radius: 5px;
        background: rgb(23, 162, 184);
        color: white;
        padding: 15px;
        margin-top: 15px;
        font-size: 16px;
        text-decoration: none;
    }
    .button:hover {
        background: darkblue;
        cursor: pointer;
    }
    .products {
        padding: 20px;
    }
    ul {
        margin-left: 20%;
        text-align: left;
        list-style: inside;
    }
    .center {
        text-align: center;
    }
    .distance {
        margin: 20px;
    }
    .left {
        float: left;
        margin-left: 20%;
    }
    .right {
        float: right;
        margin-right: 20%;
    }
    .medium{
        font-size: 20px;
    }
    .footer {
        background-color: darkgray;
    }
    .warning {
        color: white;
        background-color: orangered;
    }
    form{
        margin-left: auto;
        margin-right: auto;
        width: 300px;
        padding: 30px;
    }
    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0 16px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 16px;
    }
    textarea{
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0 16px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 16px;
        resize: none;
    }

</style>

