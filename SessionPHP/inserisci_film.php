<?php
    session_start();

    // Credenziali accesso
    $hostname = "localhost";
    $username = "utente00";
    $password = "";
    $database = "cinema";

    // Connessione al database
    $db_conn = mysqli_connect($hostname, $username, $password, $database);
    if(!$db_conn) die("Accesso al database non riuscito: " . mysqli_error($db_conn));

    $codAttore = $_SESSION['codAttore'];
    $codFilm = $_POST['codFilm'];
    $titolo = $_POST['titolo'];
    $annoProduzione = $_POST['annoProduzione'];
    $nazionalita = $_POST['nazionalita'];
    $regista = $_POST['regista'];
    $genere = $_POST['genere'];

    // Prima query per inserire il film
    $strSQL1 = "INSERT INTO film (codFilm, titolo, annoProduzione, nazionalita, regista, genere) ";
    $strSQL1 .= "VALUES ('$codFilm', '$titolo', '$annoProduzione', '$nazionalita', '$regista', '$genere');";

    $result1 = mysqli_query($db_conn, $strSQL1);

    // Verifica che il film sia stato inserito correttamente
    if($result1) {
        // Seconda query per inserire la relazione recita
        $strSQL2 = "INSERT INTO recita (codAttore, codFilm) VALUES ('$codAttore', '$codFilm');";
        $result2 = mysqli_query($db_conn, $strSQL2);

        if($result2){
            header("Location: welcome.php");
            exit();
        } else {
            echo "Errore nella seconda query: " . mysqli_error($db_conn);
        }
    } else {
        echo "Errore nella prima query: " . mysqli_error($db_conn);
    }
?>
