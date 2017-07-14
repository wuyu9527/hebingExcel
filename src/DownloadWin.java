import Bean.AllianceFirst;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by android on 2017/7/13.
 */
public class DownloadWin extends JFrame implements ActionListener {

    /**   *    */
    private static final long serialVersionUID = -7226361346020458023L;
    private JTextField httpLine;//第一个地址
    private String firstPath = "";
    private JTextField savePath;
    private JTextField percentage;//佣金百分比
    private JTextField nearly;//几天过期
    private String percentageString = "10";//默认10
    private String nearlyDayNum = "";//默认10
    private String secondPath = "";
    private JButton btnDownload;
    private JButton first;//列表1
    private JButton second;//列表2
    private FileDialog log_open;
    private JLabel lineLabel;
    private JLabel saveLabel;
    private static JLabel infoLabel;
    private ExcelReader excelReader;
    private DoAllianceFirst doAllianceFirst;

    public DownloadWin(String title) {
        init();
        setTitle(title);
        ImageIcon test = new ImageIcon("src/icon/is_mine.jpg");//第一句
        setIconImage(test.getImage()); //第二句
        setSize(400, 200);
        setLayout(new GridLayout(1, 1, 0, 0));//为美观考虑，第二行没有使用。
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void init() {
        Box baseBox = Box.createVerticalBox();
        Box boxV0 = Box.createVerticalBox();
        Box boxV1 = Box.createHorizontalBox();
        Box boxV2 = Box.createHorizontalBox();
        Box boxV3 = Box.createHorizontalBox();
        Box boxV4 = Box.createHorizontalBox();
        Box boxV5 = Box.createHorizontalBox();
        lineLabel = new JLabel("一地址：");
        httpLine = new JTextField();
        saveLabel = new JLabel("二地址：");
        savePath = new JTextField();
        JLabel commissionPercentage = new JLabel("佣金百分比");
        JLabel nearlyDay = new JLabel("天有效期");
        nearly = new JTextField();
        nearly.setText(nearlyDayNum);
        percentage = new JTextField();
        percentage.setText(percentageString);
        btnDownload = new JButton("生成回复");
        first = new JButton("第一个列表");
        second = new JButton("第二个列表");
        infoLabel = new JLabel();/**     * 监听器    */
        excelReader = new ExcelReader();
        //DownloadListener listener = new DownloadListener(httpLine, savePath, infoLabel);//将需要改变显示状态的控件传递过去处理
        btnDownload.addActionListener(this);
        doAllianceFirst = new DoAllianceFirst();
        //first.addActionListener(new );
        log_open = new FileDialog(this, "打开文件对话框", FileDialog.LOAD);
        first.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log_open.setVisible(true);
                String s = null;
                if (log_open.getFile() != null) {
                    File file = new File(log_open.getDirectory(), log_open.getFile());
                    if (file.exists()) {
                        httpLine.setText(file.getAbsolutePath());
                        System.out.println(file.getAbsolutePath());
                        firstPath = file.getAbsolutePath();
                    }
                }
            }
        });
        second.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log_open.setVisible(true);
                String s = null;
                if (log_open.getFile() != null) {
                    File file = new File(log_open.getDirectory(), log_open.getFile());
                    if (file.exists()) {
                        savePath.setText(file.getAbsolutePath());
                        System.out.println(file.getAbsolutePath());
                        secondPath = file.getAbsolutePath();
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
        boxV3.add(commissionPercentage);
        boxV3.add(percentage);
        boxV3.add(nearly);
        boxV3.add(nearlyDay);
        boxV4.add(btnDownload);
        boxV5.add(infoLabel);
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

    /*
     * 关键词
     [img]http://img.alicdn.com/bao/uploaded/i4/TB1A_YqSXXXXXanXFXXXXXXXXXX_!!0-item_pic.jpg[/img][结束]\n
     \n 夏梵尼露肩短袖白色T恤女装夏季2017新款韩范小心机学生清新上衣
     \n 淘口令 KXhB0ZgSbY2
     \n 点此链接 https://s.click.taobao.com/auNwpfw
     \n 价格:59.00

     关键词
     回复消息
     *
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!firstPath.equals("")) {
            File file = new File(firstPath);
            if (file.exists()) {
                try {
                    ArrayList<AllianceFirst> allianceFirsts = excelReader.readXls(file);
                    String num1 = "";
                    if (percentageString.matches("^([1-9]\\d|\\d)$")) {
                        num1 = percentageString;
                    }
                    String days = "";
                    if (nearlyDayNum.matches("^([1-9]\\d|\\d)$")) {
                        days = nearlyDayNum;
                    }
                    ArrayList<AllianceFirst> allianceFirsts1 = doAllianceFirst.doAllianceFirst(allianceFirsts, num1, days);
                    String path = firstPath.substring(0, firstPath.lastIndexOf("\\")) + "\\关键字自动回复.txt";
                    String path1 = firstPath.substring(0, firstPath.lastIndexOf("\\")) + "\\微信.txt";
                    File file1 = new File(path);
                    if (file1.exists()) {
                        file1.delete();
                    }
                    file1.createNewFile();
                    File file2 = new File(path1);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    String content = "";
                    for (AllianceFirst allianceFirst : allianceFirsts1) {
                        String string = allianceFirst.getName();
                        int count = getAllPager(string.length());
                        String str = "";
                        for (int i = 1; i < count + 1; i++) {
                            if (i == count) {
                                str += string.substring(0, string.length()) + ",";
                            } else {
                                str += string.substring(0, onePager * i) + ",";
                                if (i != 1) {
                                    int i1 = i - 1;
                                    str += string.substring(onePager * i1, onePager * i) + ",";
                                }
                            }
                        }
                        content += str.substring(0,str.length()-1) + "\r\n";
                        content += "[img]" + allianceFirst.getUrlImage() + "[/img][结束]\n \n" + allianceFirst.getName() + "\n 淘口令 " + allianceFirst.getTaobaoPassword() + "\n 点此链接 " + allianceFirst.getCouponShortChain() + "\n 商品价格 " + allianceFirst.getGoodsPirce();
                        content += "\r\n";
                        content += "\r\n";
                    }
                    writeTxtFile(content, file1);
                    String weixin = "*回复以下关键字获取商品*\r\n";
                    for (AllianceFirst allianceFirst : allianceFirsts1) {
                        weixin+=allianceFirst.getName().substring(0,onePager)+"\r\n";
                    }
                    writeTxtFile(weixin,file2);
                } catch (IOException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(getContentPane(), "文件读取错误", "提示信息", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(getContentPane(), "文件不存在,亲!检查下文件地址是否错误", "提示信息", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(getContentPane(), "未选择地址!", "提示信息", JOptionPane.INFORMATION_MESSAGE);
//            JOptionPane.showMessageDialog(getContentPane(), "弹出的是消息提示框!", "系统信息", JOptionPane.INFORMATION_MESSAGE);//圆叹号
//            JOptionPane.showMessageDialog(getContentPane(), "弹出的是警告提示框!", "系统信息", JOptionPane.WARNING_MESSAGE);//三角叹号
//            JOptionPane.showMessageDialog(getContentPane(), "弹出的是错误提示框!", "系统信息", JOptionPane.ERROR_MESSAGE);//红叉
//            JOptionPane.showMessageDialog(getContentPane(), "弹出的是询问提示框!", "系统信息", JOptionPane.QUESTION_MESSAGE);//问号
        }
    }

    public static boolean writeTxtFile(String content, File fileName) throws Exception {
        RandomAccessFile mm = null;
        boolean flag = false;
        FileOutputStream o = null;
        try {
            o = new FileOutputStream(fileName);
            o.write(content.getBytes("GBK"));
            o.close();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mm != null) {
                mm.close();
            }
        }
        return flag;
    }

    /**
     * @param total 总数
     * @return 总页数
     * onePager 一页几个
     */
    public int getAllPager(int total) {
        int pageCount = total / onePager + 1;
        if (total % onePager == 0) {
            pageCount = total / onePager;
        }
        return pageCount;
    }

    private int onePager = 7;
}
