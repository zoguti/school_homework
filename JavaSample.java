
import java.io.File;
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.*;
import java.io.*;
import java.util.*;

public class JavaSample extends Application
{
	public void start(Stage stage) throws Exception
	{
		//画像


		ObservableList<Node> lst;
		Rectangle2D screensize = Screen.getPrimary().getBounds();

		FileChooser fc = new FileChooser(); // オブジェクトの作成
		fc.setTitle("画像ファイルの選択"); // ダイアログタイトルの設定
		List<File> files = fc.showOpenMultipleDialog(stage);
		// 自身のステージを指定して、
		// ダイアログのオープンと選択

		ImageView[] iv=new ImageView[10];
		for(int i=0;i<files.size();i++)
		{
			File f = files.get(i);
			iv[i]=new ImageView(f.getName());
			if (i==0 || i==1)
			{
				iv[i].setFitHeight(screensize.getHeight()/2);
				iv[i].setFitWidth(screensize.getWidth()/2);
			}
			else
			{
				iv[i].setFitHeight(screensize.getHeight()/2/2);
				iv[i].setFitWidth(screensize.getWidth()/2/2);
			}



		}
		GridPane gp1 = new GridPane();
		gp1.add(iv[6], 0, 0);
		gp1.add(iv[7], 0, 1);
		gp1.add(iv[8], 1, 0);
		gp1.add(iv[9], 1, 1);

		GridPane gp2 = new GridPane();
		gp2.add(iv[2], 0, 0);
		gp2.add(iv[3], 0, 1);
		gp2.add(iv[4], 1, 0);
		gp2.add(iv[5],1, 1);



		FlowPane[ ] flow=new FlowPane[2];
		flow[0]=new FlowPane();
		flow[1]=new FlowPane();
		lst = flow[0].getChildren();
		lst.addAll(iv[0],gp1);
		lst = flow[1].getChildren();
		lst.addAll(gp2,iv[1]);

		VBox vbox=new VBox();
		lst= vbox.getChildren();
		lst.addAll(flow);

		Scene scene = new Scene(vbox);

		stage.setScene(scene);
		stage.setTitle("sa");
		stage.setMaximized(true);
		//下のコードは何か違う
	//	stage.setHeight(screensize.getHeight());
	//	stage.setWidth(screensize.getWidth());
		stage.show();

	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
