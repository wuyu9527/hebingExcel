import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by android on 2017/7/13.
 */
public class DownloadWin extends JFrame {

    /**   *    */
    private static final long serialVersionUID = -7226361346020458023L;
    private JTextField httpLine;
    private JTextField savePath;
    private JButton btnDownload;
    private JButton first;//列表1
    private JButton second;//列表2
    private FileDialog log_open;
    private JLabel lineLabel;
    private JLabel saveLabel;
    private static JLabel infoLabel;


    public DownloadWin(String title) {
        init();
        setTitle(title);
        setSize(400, 300);
        setLayout(new GridLayout(2, 1, 0, 0));//为美观考虑，第二行没有使用。
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void init() {
        Box baseBox = Box.createVerticalBox();
        Box boxV1 = Box.createHorizontalBox();
        Box boxV2 = Box.createHorizontalBox();
        Box boxV3 = Box.createHorizontalBox();
        Box boxV4 = Box.createHorizontalBox();
        Box boxV5 = Box.createHorizontalBox();
        lineLabel = new JLabel("访问地址：");
        httpLine = new JTextField();
        saveLabel = new JLabel("保存路径：");
        savePath = new JTextField();
        btnDownload = new JButton("下载");
        first = new JButton("第一个列表");
        second = new JButton("第二个列表");
        infoLabel = new JLabel();/**     * 监听器    */
        DownloadListener listener = new DownloadListener(httpLine, savePath, infoLabel);//将需要改变显示状态的控件传递过去处理
        btnDownload.addActionListener(listener);
        //first.addActionListener(new );
        log_open = new FileDialog(this, "打开文件对话框", FileDialog.LOAD);
        first.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log_open.setVisible(true);
                String s = null;
                if (log_open.getFile() != null) {
                    File file = new File(log_open.getDirectory(), log_open.getFile());
                    if (file.exists()){
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        });
        boxV1.add(lineLabel);
        boxV1.add(httpLine);
        boxV1.add(first);
        boxV2.add(saveLabel);
        boxV2.add(savePath);
        boxV2.add(second);
        boxV3.add(btnDownload);
        boxV4.add(infoLabel);
        baseBox.add(boxV1);
        Box.createVerticalStrut(15);
        baseBox.add(boxV2);
        Box.createVerticalStrut(15);
        baseBox.add(boxV3);
        Box.createVerticalStrut(15);
        baseBox.add(boxV4);
        Box.createVerticalStrut(15);
        baseBox.add(boxV5);
        add(baseBox);
    }
}