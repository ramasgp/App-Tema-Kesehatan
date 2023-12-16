import java.util.*;
import java.io.*;

public class Aplikasi
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int pilih, logged = 0;
        String namaDokter = "";
        for(;;)
        {
            System.out.println("=========SI Kota Kembang=========");
            System.out.println("1. Masuk sebagai dokter");
            System.out.println("2. Masuk sebagai apoteker");
            System.out.println("3. Masuk sebagai pasien");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan anda : ");
            pilih = input.nextInt();
            switch(pilih)
            {
                case 1:
                    while(logged == 0)
                    {
                        logged = loginNakes("dokter");
                        namaDokter = identitasDokter(logged);
                    }
                    break;
                case 2:
                    while(logged == 0)
                    {
                        logged = loginNakes("apoteker");
                    }
                    break;
                case 3:
                    logged = -1;
                    break;
                case 4:
                    System.exit(0);
                default: System.out.println("Pilihan tidak ditemukan");
            }
            if (logged != 0)
                break;
        }
        System.out.println("Berhasil login");
        switch(pilih)
        {
            case 1:
            {
                System.out.println("Masuk sebagai " + namaDokter);
                while(true)
                {
                    System.out.println("=========SI Dokter=========");
                    System.out.println("1.Lihat daftar pertemuan");
                    System.out.println("2.Lihat permintaan surat rekomendasi");
                    System.out.println("3.Lihat konsultasi online");
                    System.out.println("4.Meresepkan obat");
                    System.out.println("5.Keluar");
                    System.out.println("===========================");
                    System.out.print("Masukkan pilihan anda : ");
                    input.nextLine();
                    int opsi = input.nextInt();
                    switch(opsi)
                    {
                        case 1:
                            prosesDatabase("dokter\\" + logged);
                            break;
                        case 2:
                            prosesDatabase("rujukan");
                            break;
                        case 3:
                            prosesDatabase("konsul");
                            break;
                        case 4:
                            resepObat(namaDokter);
                            break;
                        case 5:
                            System.out.println("Terima kasih sudah menggunakan SI Kesehatan Kota Kembang");
                            System.exit(0);
                    }
                }
            }
            case 2:
            {
                while(true)
                {
                    System.out.println("========SI Apoteker========");
                    System.out.println("1.Lihat daftar permintaan obat");
                    System.out.println("2.Keluar");
                    System.out.print("Masukkan pilihan anda : ");
                    input.nextLine();
                    int opsi = input.nextInt();
                    switch(opsi)
                    {
                        case 1:
                            prosesDatabase("pesananObat");
                            break;
                        case 2:
                            System.out.println("Terima kasih sudah menggunakan SI Kesehatan Kota Kembang");
                            System.exit(0);
                    }
                }
            }
            case 3:
            {
                while(true)
                {
                    System.out.println("=========SI Pasien=========");
                    System.out.println("1. Informasi RS Terdekat");
                    System.out.println("2. Booking pertemuan dengan dokter");
                    System.out.println("3. Konsultasi online");
                    System.out.println("4. Meminta surat rujukan");
                    System.out.println("5. Pesan obat online");
                    System.out.println("6. Keluar");
                    System.out.println("===========================");
                    System.out.print("Masukkan pilihan anda : ");
                    input.nextLine();
                    int opsi = input.nextInt();
                    switch(opsi)
                    {
                        case 1:
                            rsTerdekat();
                            break;
                        case 2:
                            BookingPertemuan();
                            break;
                        case 3:
                            KonsultasiOnline();
                            break;
                        case 4:
                            suratRujukan();
                            break;
                        case 5:
                            pesanObat();
                            break;
                        case 6:
                        System.out.println("Terima kasih sudah menggunakan SI Kesehatan Kota Kembang");
                        System.exit(0);
                    break;
                    }
                }
            }
        }
    }

    private static Integer loginNakes(String identitasNakes)
    {
        String NI,password,temp,validation;
        Scanner nakes = new Scanner(System.in);
        try
        {
            File obj = new File("FinalProject\\" + identitasNakes + ".txt");
            Scanner reader = new Scanner(obj);
            System.out.print("Masukkan nomor identitas anda : ");
            NI = nakes.nextLine();
            System.out.print("Masukkan password anda : ");
            password = nakes.nextLine();
            validation = NI + "-" + password;
            while (reader.hasNextLine())
            {
                temp = reader.nextLine();
                if (temp.equals(validation))
                {
                    int nomorDokter = reader.nextInt();
                    reader.close();
                    return nomorDokter;
                }
            }
            reader.close();
            System.out.println("Data tidak ditemukan");
            return 0;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Terjadi kesalahan sistem");
            e.printStackTrace();
        }
        return 0;
    }

    public static String identitasDokter(int nomorSeridr)
    {
        switch(nomorSeridr)
        {
            case 1: return "dr. Ariana";
            case 2: return "dr. Jefri";
            case 3: return "dr. Rodia";
            case 4: return "dr. Jessica";
            case 5: return "dr. Monalisa";
            case 6: return "dr. Farhan";
            case 7: return "dr. Rama";
            case 8: return "dr. Aldiansyah";
            case 9: return "dr. Tia";
            case 10: return "dr. Qayla";
            default: return "(Terjadi Kesalahan Sistem)";
        }
    }

    public static void rsTerdekat(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Kecamatan Kota Kembang ");
        System.out.println("1. Mawar Putih ");
        System.out.println("2. Tulip Asri ");
        System.out.println("3. Melati Arum ");
        System.out.println("4. Aglonema ");
        System.out.println("5. Kamboja Kuning");
        System.out.print("Pilih Kecamatan : ");
        int pilihan = sc.nextInt();
        switch (pilihan){
            case 1 :
                System.out.println("RSUD Sayonara  : Jl. Kalajengking");
                System.out.println("RSUD Bina Raya : Jl. Zebra 3 ");
                break;
            case 2 :
                System.out.println("RSUD Kasih Ibu : Jl. Kelinci Putih");
                System.out.println("RSUD Mariam    : Jl. Buaya Rawa");
                break;
            case 3 :
                System.out.println("RSUD Mutiara   : Jl. Kuda Lumping");
                System.out.println("RSUD Bromance  : Jl. Kucing Kampung");
                break;
            case 4 :
                System.out.println("RSUD Kayangan  : Jl. Cacing Pita");
                System.out.println("RSUD Mahatma   : Jl. Kura Ninja");
                break;
            case 5 :
                System.out.println("RSUD Kitanama  : Jl. Banteng Asa");
                System.out.println("RSUD Nonajaya  : Jl. Gurita Kuning");
                break;
        }
    }

    public static void BookingPertemuan(){
        Scanner sc = new Scanner(System.in);
        int pilihanDokter = 0;
        System.out.println("===== Biodata Pasien ======");
        System.out.print("Nama      : ");
        String nama = sc.nextLine();
        System.out.print("TTL       : ");
        String ttl = sc.nextLine();
        System.out.print("Alamat    : ");
        String alamat = sc.nextLine();
        System.out.print("Nomor HP  : ");
        String noHP = sc.nextLine();
        System.out.println(" === Kecamatan Kota Kembang === ");
        System.out.println("1. Mawar Putih");
        System.out.println("2. Tulip Asri");
        System.out.println("3. Melati Arum");
        System.out.println("4. Aglonema");
        System.out.println("5. Kamboja Kuning");
        System.out.print("Pilih Kecamatan : ");
        int pilihan = sc.nextInt();
        switch (pilihan){
            case 1 :
                System.out.println("1. RSUD Sayonara  : Jl. Kalajengking");
                System.out.println("2. RSUD Bina Raya : Jl. Zebra 3 ");
                System.out.print("Pilih Rumah Sakit : ");
                int dokter = sc.nextInt();
                if (dokter == 1){
                    System.out.println("dr. Ariana");
                    pilihanDokter = 1;
                }else if (dokter == 2){
                    System.out.println("dr. Jefri");
                    pilihanDokter = 2;
                }
                break;  
            case 2 :
                System.out.println("1. RSUD Kasih Ibu : Jl. Kelinci Putih");
                System.out.println("2. RSUD Mariam    : Jl. Buaya Rawa");
                System.out.print("Pilih Rumah Sakit : ");
                int dokter2 = sc.nextInt();
                if (dokter2 == 1){
                    System.out.println("dr. Rodia");
                    pilihanDokter = 3;
                }else if (dokter2 == 2){
                    System.out.println("dr. Jessica");
                    pilihanDokter = 4;
                }
                break;
            case 3 :
                System.out.println("1. RSUD Mutiara   : Jl. Kuda Lumping");
                System.out.println("2. RSUD Bromance  : Jl. Kucing Kampung");
                System.out.print("Pilih Rumah Sakit : ");
                int dokter3 = sc.nextInt();
                if (dokter3 == 1){
                    System.out.println("dr. Monalisa");
                    pilihanDokter = 5;
                }else if (dokter3 == 2){
                    System.out.println("dr. Farhan");
                    pilihanDokter = 6;
                }
                break;
            case 4 :
                System.out.println("1. RSUD Kayangan  : Jl. Cacing Pita");
                System.out.println("2. RSUD Mahatma   : Jl. Kura Ninja");
                System.out.print("Pilih Rumah Sakit : ");
                int dokter4 = sc.nextInt();
                if (dokter4 == 1){
                    System.out.println("dr. Rama");
                    pilihanDokter = 7;
                }else if (dokter4 == 2){
                    System.out.println("dr. Aldiansyah");
                    pilihanDokter = 8;
                }
                break;
            case 5 :
                System.out.println("1. RSUD Kitanama  : Jl. Banteng Asa");
                System.out.println("2. RSUD Nonajaya  : Jl. Gurita Kuning");
                System.out.print("Pilih Rumah Sakit : ");
                int dokter5 = sc.nextInt();
                if (dokter5 == 1){
                    System.out.println("dr. Tia");
                    pilihanDokter = 9;
                }else if (dokter5 == 2){
                    System.out.println("dr. Qayla");
                    pilihanDokter = 10;
                }
                break;
        }
        System.out.print("Keluhan      : ");
        sc.nextLine();
        String keluhan = sc.nextLine();
        String biodata = nama + "\n" + ttl + "\n" + alamat + "\n" + noHP;
        tulisDatabase("dokter\\" + pilihanDokter, nama, biodata, keluhan);
    }

    public static void KonsultasiOnline()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Biodata Pasien ======");
        System.out.print("Nama      : ");
        String nama = sc.nextLine();
        System.out.print("TTL       : ");
        String ttl = sc.nextLine();
        System.out.print("Alamat    : ");
        String alamat = sc.nextLine();
        System.out.print("Nomor HP  : ");
        String noHP = sc.nextLine();
        System.out.println("===========================");
        System.out.println("Keluhan : ");
        String keluhan = sc.nextLine();
        String biodata = nama + "\n" + ttl + "\n" + alamat + "\n" + noHP;
        tulisDatabase("konsul", nama,biodata,keluhan);
    }

    public static void suratRujukan(){
        Scanner in= new Scanner(System.in);
        String nama, alamat, ttl, jnsKelamin, keluhan;
        System.out.println("SURAT RUJUKAN");
        System.out.println("====================================");
        System.out.println("BIODATA");
        System.out.println("Masukkan Nama : ");
        nama = in.nextLine();
        System.out.println("Masukkan Alamat : ");
        alamat = in.nextLine();
        System.out.println("Masukkan TTL : ");
        ttl = in.nextLine();
        System.out.println("Masukkan Jenis Kelamin : ");
        jnsKelamin = in.nextLine();
        System.out.println("Masukkan keluhan :");
        keluhan = in.nextLine();
        String biodata = nama + "\n" + jnsKelamin + "\n" + ttl + "\n" + alamat;
        tulisDatabase("rujukan", nama,biodata,keluhan);
    }

    public static void pesanObat(){
        Scanner in = new Scanner(System.in);
        int banyakBarang, harga = 0;
        String nama, alamat, ttl, jnsKelamin, jnsObat = "", temp = "\n";
        System.out.println("BIODATA");
        System.out.print("Masukkan Nama : ");
        nama = in.nextLine();
        System.out.print("Masukkan Alamat : ");
        alamat = in.nextLine();
        System.out.print("Masukkan TTL : ");
        ttl = in.nextLine();
        System.out.print("Masukkan Jenis Kelamin : ");
        jnsKelamin = in.nextLine();
        System.out.println("** Daftar Obat **");
        System.out.println("-------------------------------------");
        System.out.println("|KODE | NAMA           | HARGA/Papan|");
        System.out.println("-------------------------------------");
        System.out.println("010027 Antibiotik Amoxicillin(1) Rp 5.600");
        System.out.println("100169 Paracetamol(2)            Rp 4.500");
        System.out.println("100335 Siladex Me(3)             Rp 7.400");
        System.out.println("999991 Polysilane(4)             Rp 4.500");
        System.out.println("120201 BODREX(5)                 Rp 7.400\n");
        byte pil1 = 1;
        do {
            banyakBarang = 0;
            System.out.println("Masukkan angka obat yang ingin dibeli");
            System.out.print("=> ");
            byte kode = in.nextByte();
            switch(kode)
            {
                case 1:
                    System.out.println("Antibiotik Amoxicillin");
                    jnsObat = "Antibiotik Amoxicillin";
                    System.out.print("Banyak (papan) (gunakan angka): ");
                    banyakBarang = in.nextInt();
                    harga = harga + (banyakBarang * 5600);
                    break;
                case 2:
                    System.out.println("Paracetamol");
                    jnsObat = "Paracetamol";
                    System.out.print("Banyak (papan) (gunakan angka): ");
                    banyakBarang = in.nextInt();
                    harga = harga + (banyakBarang * 5600);
                    break;
                case 3:
                    System.out.println("Siladex Me");
                    jnsObat = "Siladex Me";
                    System.out.print("Banyak (papan) (gunakan angka): ");
                    banyakBarang = in.nextInt();
                    harga = harga + (banyakBarang * 5600);
                    break;
                case 4:
                    System.out.println("Polysilane");
                    jnsObat = "Polysilane";
                    System.out.print("Banyak (papan) (gunakan angka): ");
                    banyakBarang = in.nextInt();
                    harga = harga + (banyakBarang * 5600);
                    break;
                case 5:
                    System.out.println("Sangobion");
                    jnsObat = "Bodrex";
                    System.out.print("Banyak (papan) (gunakan angka): ");
                    banyakBarang = in.nextInt();
                    harga = harga + (banyakBarang * 5600);
                    break;
                default:
                    System.out.println("Obat tidak ditemukan");
                    break;
            }
            temp = temp + jnsObat + "          " + banyakBarang +"\n";
            System.out.println("Ingin membeli lagi?");
            System.out.println("[1] ya    [0] tidak");
            System.out.print("=> ");
            pil1 = in.nextByte();
        } while (pil1 != 0);
        String biodata = nama + "\n" + jnsKelamin + "\n" + ttl + "\n" + alamat;
        tulisDatabase("pesananObat", nama, biodata, temp);
        System.out.println("Total biaya pesanan anda : Rp." + harga);
    }

    public static void resepObat(String namaDokter){
        Scanner sc = new Scanner(System.in);
        String namaPasien, alamatPasien, noPasien, umurPasien, biodata, resep;
        System.out.print("Masukkan nama pasien : ");
        namaPasien = sc.nextLine();
        System.out.print("Masukkan alamat pasien : ");
        alamatPasien = sc.nextLine();
        System.out.print("Masukkan nomor HP pasien : ");
        noPasien = sc.nextLine();
        System.out.print("Masukkan umur pasien : ");
        umurPasien = sc.nextLine();
        System.out.print("Masukkan resep obat untuk pasien : ");
        resep = sc.nextLine();
        biodata = namaDokter + "\n" + namaPasien + "\n" + alamatPasien + "\n" + noPasien + "\n" + umurPasien;
        tulisDatabase("pesananObat", "ResepDokter_" + namaPasien, biodata, resep);
        
    }

    public static void tulisDatabase(String jenis,String nama,String biodata,String pesan)
    {
        try
        {
            File obj = new File("FinalProject\\" + jenis +"\\"+ nama +".txt");
            obj.createNewFile();
            FileWriter writer = new FileWriter("FinalProject\\" + jenis +"\\"+ nama +".txt");
            writer.write(biodata + "\n");
            writer.write("Pesan : " + pesan);
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println("Terjadi kesalahan");
            e.printStackTrace();
        }
    }

    public static void prosesDatabase(String jenis)
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            String [] fileList;
            int i, x = 0;
            File obj = new File("FinalProject\\" + jenis);
            fileList = obj.list();
            if (fileList.length == 0)
            {
                System.out.println("Tidak ada entri");
                return;
            }
            for(i = 0;i <fileList.length;i++)
            {
                System.out.println(i + ". " + fileList[i]);
            }
            System.out.print("Pilih entri yang ingin diakses : ");
            int pilihan = sc.nextInt();
            File terakses = new File("FinalProject\\" + jenis + "\\" + fileList[pilihan]);
            Scanner reader = new Scanner(terakses);
            System.out.println("====================================");
            while(reader.hasNextLine())
            {
                System.out.println(reader.nextLine());
            }
            System.out.println("====================================");
            System.out.print("Tekan enter untuk melanjutkan");
            sc.nextLine();
            reader.close();
            sc.nextLine();
            while(x == 0)
            {
                System.out.print("Hapus entri (y/n)?");
                String hapus = sc.nextLine();
                switch(hapus)
                {
                    case "y":
                        if (terakses.delete())
                            System.out.println("Entri berhasil dihapus");
                        else 
                            System.out.println("Gagal menghapus entri");
                        x = 1;
                        break;
                    case "n":
                        x = 1;
                        break;
                    default:
                        System.out.println("Opsi tidak ditemukan");
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Terjadi kesalahan sistem");
            e.printStackTrace();
        }
    }

}
