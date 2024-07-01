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

    //raccolta dei dati inseriti nel form
    $nome = $_POST["nome"];

    //query
    $strSQL = "SELECT * FROM attori WHERE nome = '$nome'";
    $result = mysqli_query($db_conn, $strSQL);

    //verifica corrispondenze 
    if(mysqli_num_rows($result) > 0){
        $row = mysqli_fetch_assoc($result);
        $_SESSION['codAttore'] = $row['codAttore'];
        echo "<h3>Login riuscito!</h3>";
        header("Location: welcome.php");
        exit();
    } else {
        echo "<h3>Credenziali non valide!</h3>";
    }
    mysqli_close($db_conn);

?>