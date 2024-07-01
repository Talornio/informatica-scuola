<?php
    //avvia la sessione
    session_start();

    //credenziali accesso
    $hostname = "localhost";
    $username = "utente00";
    $password = "";
    $database = "cinema";
    //connessione al database
    $db_conn = mysqli_connect($hostname, $username, $password, $database);
    if(!$db_conn) die("Accesso al database non riuscito: ".mysqli_error($db_conn));

    $codAttore = $_POST['codAttore'];
    $nome = $_POST['nome'];
    $annoNascita = $_POST['annoNascita'];
    $nazionalita = $_POST['nazionalita'];

    $strSQL = "INSERT INTO attori (codAttore, nome, annoNascita, nazionalita) VALUES ('$codAttore', '$nome', '$annoNascita', '$nazionalita');";

    $result = mysqli_query($db_conn, $strSQL);

    if($result){
        $_SESSION['codAttore'] = $codAttore;
        echo "appost inserito <br><br>";
        header("Location: welcome.php");
        exit();
    }else {
        echo "ohnno non funziona bro! Errore: <br>". mysqli_error($db_conn);
    }
?>