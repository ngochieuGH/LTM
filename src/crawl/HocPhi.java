/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crawl;

/**
 *
 * @author Admin
 */
public class HocPhi {
    private String ID, name;
    private String[] giaTri;
//    public HocPhi(String ID, String name, String[] giaTri){
//        this.ID = ID;
//        this.name = name;
//        this.giaTri = giaTri;
//    }

    public String[] getGiaTri() {
        return giaTri;
    }

    public String getID() {
        return ID;
    }
    
    public String getName() {
        return name;
    }


    public void setID(String ID) {
        this.ID = ID;
    }
    
    public void setName(String name) {
        this.name = name;
    }


    public HocPhi(String chuoi) {
        // Tách chuỗi thành các phần tử
        String[] parts = chuoi.split(" ");
        //System.out.println(parts.length);
        if(parts.length >= 14){
            // Lưu giá trị vào các trường tương ứng
            this.ID = parts[0];
            this.name = parts[1] + " " + parts[2] + " " + parts[3] + " " + parts[4] + " " + parts[5]+ " " + parts[6]+ " " + parts[7]+ " " + parts[8];

            // Số lượng giá trị còn lại từ parts
            this.giaTri = new String[parts.length - 9];
            for (int i = 9; i < parts.length; i++) {
                this.giaTri[i - 9] = parts[i];
            }
        }
    }
}
