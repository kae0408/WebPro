<?php
    error_reporting(E_ALL);
    ini_set( "display_errors", 1 );
    /*エラー表示*/
    $pdo = new PDO("mysql:host=easy-twitter.carvwyxzqhht.us-east-2.rds.amazonaws.com;dbname=twitter;charset=utf8","master","masterpass");
    /*データベース接続*/
    //host ホスト名
    //dbname データベース名
    if(isset($_POST["datapost"])){
    //$_POSTを直接DBに挿入するのはセキュリティ上推奨されないので、一度変数に移す
    $user = $_POST["user"];
    $contents = $_POST["contents"];
    //登録準備
    $stmt = $pdo -> prepare("INSERT INTO tweet123(user, contents) VALUES(:user, :contents)");
    //登録する文字の型を固定
    //セキュリティ対策してるよ
    $stmt -> bindValue(":user", $user, PDO::PARAM_STR);
    $stmt -> bindValue(":contents", $contents, PDO::PARAM_STR);
    //データベースの登録を実行
    $stmt -> execute();
}
    $stmt = $pdo -> prepare("SELECT * FROM tweet123 ORDER BY time DESC");
    $stmt -> execute();
    //テーブルの情報を全て取得
    $data = $stmt -> fetchAll();

?>


<!DOCTYPE html>
<html lang="ja">
   <head>
     <meta charset="UTF-8">
     <title>Twitter</title>
     <link rel="stylesheet" href="index.css">
   </head>
<body>
  <img src="logo.png">
  <form action="" method="post">
    <input type="password" name="user" placeholder="ニックネーム">
    <br>
　  <textarea name="contents" rows="4" cols="35" placeholder="内容書いて〜"></textarea>
    <br>
    <input type="submit" name="datapost" value="ツイートする">
  </form>

<div class="boxwp">
<?php for($i=1; $i<21; $i++){ ?>
  <div class="box">
    <p class="name"><?php echo $data["$i"]["user"]; ?></p>
    <p><?php echo $data["$i"]["contents"]; ?></p>
  </div>
<?php } ?>
</div>

</body>
</html>
