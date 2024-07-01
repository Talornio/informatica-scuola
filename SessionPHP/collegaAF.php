<?php

    session_start();

    $hostname = "localhost";
    $username = "utente00";
    $password = "";
    $database = "cinema";

    $conn = mysqli_connect($hostname, $username, $password, $database);

    if(!$conn)
    {
        die(mysqli_error($conn));
    }

    // Usa le parentesi quadre per accedere ai valori POST
    $nome = $_POST['nomeAttore'];
    $titolo = $_POST['nomeFilm'];

    $query1 = "SELECT codAttore FROM attori WHERE nome = '$nome'; ";
    $query2 = "SELECT codFilm FROM film WHERE titolo = '$titolo'; ";

    $result1 = mysqli_query($conn, $query1);
    $result2 = mysqli_query($conn, $query2);

    if(mysqli_num_rows($result1) >  0 && mysqli_num_rows($result2) > 0)
    {
        $row1 = mysqli_fetch_assoc($result1);
        $row2 = mysqli_fetch_assoc($result2);

        $codAttore = $row1['codAttore'];
        $codFilm = $row2['codFilm'];

        $query3 = "INSERT INTO recita(codAttore, codFilm) VALUES ('$codAttore', '$codFilm');";

        $result3 = mysqli_query($conn, $query3);

        if($result3)
        {
            header("Location: welcome.php");
            exit();
        }
        else
        {
            echo "Errore nell'inserimento: " . mysqli_error($conn);
        }
    }
    else
    {
        echo "Dati inseriti errati";
    }

?>
