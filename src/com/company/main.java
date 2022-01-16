package com.company;

/*
 lam theo dang menu
 ---Quan Li San Pham---
1. Hien Thi Danh Sach San Pham
2. Them San Pham
3. Cap Nhat San Pham Moi
4. Xoa San Pham
5. Sap Xep Danh Sach San Pham
6. Tim Kiem
0. Thoat
Mời Bạn Nhập Lựa Chọn
 **/

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        int choice = -1; // để nhập lựa chọn của người dùng.
        Product[] products = new Product[2];
        products[0] = new Product(1, "iphone 13", 35000000, "Hang moi");
        products[1] = new Product(2, "iphone 12", 30000000, "Hang moi");

        do {
            menu();
            System.out.println(" Moi Ban Nhap Lua Chon");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("---Danh sach san pham---");
                    if (products.length == 0) {
                        System.out.println(" khong co san pham nao");
                    } else {
                        displayAllProduct(products);

                        break;
                    }
                }
                case 2: {

                    System.out.println("Nhap Vi Tri Ban Muon Them");
                    int index = scanner.nextInt();
                    if (index < 0 || index > products.length) {
                        System.out.println("vị trí không phù hợp");
                    } else {
                        Product newProduct = inputProduct(scanner);
                        products = addNewProducts(products, index, newProduct);
                    }
                    break;
                }
                case 3: {
                    System.out.println(" Cập nhật sản phẩm");
                    System.out.println(" nhập vị trí cần chỉnh sửa");
                    int index= scanner.nextInt();
                    if (index<0 || index>=products.length) {
                        System.out.println(" vị trí không hợp lệ");
                    }else {
                        Product newProduct = inputProduct(scanner);
                        products[index]=newProduct;
                    }
                    break;
                }
                case 4: {
                    System.out.println("---Xoa San Pham---");
                    System.out.println(" nhập vi trí cần xóa ");
                    int index= scanner.nextInt();
                    if (index<0 || index>=products.length) {
                        System.out.println(" vị trí không hợp lệ");
                    } else {
                        Product[] newProducts = new Product[products.length-1];
                        for (int i=0; i<newProducts.length;i ++ ) {
                            if (i<index){
                                newProducts[i]= products[i];
                            } else {
                             newProducts[i]= products[i+1];
                            }
                        }
                        products=newProducts;

                    }

                    break;
                }
                case 5: {
                    System.out.println(" Sắp xếp sản phẩm theo tên");
                    sortProductList(products);

                    break;
                }
                case 6: {
                    System.out.println(" Tìm kiếm Sản phẩm theo tên");
                    System.out.println(" nhập tên sản phẩm cần tìm");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    int index= findProduct(products, name);

                    if (index==-1){
                        System.out.println("không tìm thấy");
                    }else {
                        System.out.println(" thông tin sản phâm cần tìm là: "+products[index]);
                    }
                    break;
                }
                default: {
                    System.out.println("So Nhap Vao Khong Hop Le");
                }
            }


        } while (choice != 0);
    }
    public static int findProduct(Product[] products, String name){
        int index= -1;
        for (int i=0; i<products.length; i++){
            if (products[i].getName().equals(name)){
                index=i;
                break;
            }
        }
        return index;
    }



    public  static void sortProductList(Product[] products){
        for (int i= 0; i<products.length; i++){
            for (int j=0; j<products.length; j++){
                if (products[i].getName().compareTo(products[j].getName())>0){
                    // >0 có nghĩa sắp sếp từ lớn đến bé products[i]>products[j]
                    // phuong thuc compareTo sẽ trả về 3 trá giá trị -1, 0, 1
                    Product temp = products[i];
                    products[i]=products[j];
                    products[j]=temp;
                }
            }
        }

    }

    public static Product[] addNewProducts(Product[] products, int index, Product newProduct){
        Product[] newProducts = new Product[products.length + 1];
        for (int i = 0; i < newProducts.length; i++) {
            if (i < index) {
                newProducts[i] = products[i];
            } else if (i == index) {
                newProducts[i] = newProduct;
            } else {
                newProducts[i] = products[i - 1];
            }
        }
        return newProducts;


    }

    public static Product inputProduct(Scanner scanner){ //nhap thong tin san pham
        System.out.println(" Nhap Thong Tin San Phan");
        System.out.println(" Nhap Id San Pham");
        int id = scanner.nextInt();
        System.out.println(" Nhap Ten San pham");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println(" Nhap Gia San Pham");
        double price = scanner.nextDouble();
        System.out.println(" Nhap Mo Ta San Pham");
        scanner.nextLine();
        String description = scanner.nextLine();
        Product newProduct = new Product(id, name, price, description);
        return newProduct;
    }

    public static void menu() {
        System.out.println("---Menu Quan Li San Pham---");
        System.out.println("1. Hien Thi Danh Sach San Pham");
        System.out.println("2. 2. Them San Pham");
        System.out.println("3. Cap Nhat San Pham Moi");
        System.out.println("4. Xoa San Pham");
        System.out.println("5. Sap Xep Danh Sach San Pham Theo ten");
        System.out.println("6. Tim Kiem");
        System.out.println("0. Thoat");

    }

    public static void displayAllProduct(Product[] products) { // hien thi danh sach san pham
        System.out.println("Danh Sach San Pham");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i+1+"\t"+products[i]);
        }
    }

}
