<?php

	if($_SERVER['REQUEST_METHOD'] == 'POST'){

		$id = $_POST['id'];
		$photo = $_POST['photo'];

		$path = "profile_image/".$id.".jpeg";
		$finalPath = "http://192.168.8.104/RegisterWithVolley1/".$path;


		require_once 'connect.php';

		$sql = "update users2 set imageurl= '$finalPath' where id= '$id' ";

		if(mysqli_query($conn, $sql)){
			if(file_put_contents($path, base64_decode($photo))){
				$result["success"] = "1";
				$result["message"] = "Success";

				json_encode($result);
				mysqli_close($conn);
			}
		}
		else{
			$result['success'] = "0";
			$result['message'] = "error in file";
			json_encode($result);
			mysqli_close($conn);
		}


	}else{
			$result['success'] = "0";
			$result['message'] = "error in file2";
			json_encode($result);
			mysqli_close($conn);
		}






?>