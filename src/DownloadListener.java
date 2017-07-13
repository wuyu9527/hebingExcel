import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by android on 2017/7/13.
 */
public class DownloadListener implements ActionListener {
    private JTextField httpLine, savePath;
    private JLabel infoLabel;
    private	String httpAddress;
    private String fileName;
    private String fileDir;
    private File file;
    private URL url;
    private URLConnection conn;
    private InputStream itStream;
    private DataInputStream in;
    private FileOutputStream otStream;
    private DataOutputStream out;
    public DownloadListener(JTextField httpLine, JTextField savePath,
                            JLabel infoLabel) {
        this.httpLine = httpLine;
        this.infoLabel = infoLabel;
        this.savePath = savePath;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        httpAddress	= httpLine.getText();
        fileDir = savePath.getText();
        infoLabel.setText("");
        downFile(httpAddress,fileDir);

    }

    /**
     * @param httpAddress
     * <p>下载链接
     * @param fileDir
     * <p>文件保存目录
     */
    private void downFile(String httpAddress, String fileDir) {

        SplitString httpSplit = new SplitString();
        fileName = httpSplit.split(httpAddress,"/");//根据“/”分解
        System.out.println(fileName);
        if(""==fileName||null==fileName||""==fileDir||null==fileDir){
            System.out.println("网络地址或保存路径不正确");
            infoLabel.setText("网络地址或保存路径不正确");
        }
        else{
            System.out.println("下载中...");
            infoLabel.setText("下载中...");
            try {
                url = new URL(httpAddress);//设置链接
                conn = url.openConnection();//打开链接
                file = new File(fileDir,fileName);
                //获取链接指向的文件的相关数据
                itStream = conn.getInputStream();
                //				in = new DataInputStream(itStream);//数据输入流
                otStream = new FileOutputStream(file);//根据文件创建输出流
                //				out = new DataOutputStream(otStream);//数据输出流
                file.createNewFile();
                int n=0;
                int sum = 0;
                byte b[] = new byte[1];//用来存放网络上下载的数据缓冲
				/*
				 * 本机测试，byte数组长度超过2，下载稍大的压缩文件，就会导致压缩文件出错，其他文档也可能出问题
				 * 最好长度为1，但是效率估计会很低下
				 */
                while((n=itStream.read(b))!=-1){
                    otStream.flush();
                    otStream.write(b);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    //										otStream.flush();//刷新此输出流并强制写出所有缓冲的输出字节
                    //					in.close();
                    itStream.close();
                    //					out.close();
                    otStream.close();
                } catch (IOException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }
            }
        }
        System.out.println("下载完成！");
        infoLabel.setText("下载完成！");
    }
}

