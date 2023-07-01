## Hungarian Algorithm Introduction
Hungarian Algorithm (Algoritma Hungarian) yang juga dikenal sebagai Algoritma Penugasan adalah algoritma yang digunakan untuk menyelesaikan masalah penugasan dengan kompleksitas waktu yang efisien. Misalnya, dalam masalah penugasan, terdapat studi kasus tentang karyawan dan tugas yang perlu diselesaikan, tujuan algoritma ini adalah menemukan penugasan optimal di mana waktu atau biaya yang dibutuhkan untuk menyelesaikan tugas-tugas tersebut adalah minimal.

## More About Hungarian Algorithm
Anda bisa mengunjungi website [ini](https://www.hungarianalgorithm.com/index.php) untuk mengetahui lebih dalam mengenai hungarian algorithm dan juga langkah-langkah algoritmanya.

## Using This Program
Diberikan sebuah soal cerita sederhana yang mungkin Anda sudah sering temui dulu di bangku sekolah.
> Sebuah perusahaan mempekerjakan beberapa karyawan untuk beberapa bagian/divisi. Tabel di bawah ini menunjukkan nama karyawan dan upah yang mereka minta untuk bagian tersebut.

|Karyawan  | Adonan    | Memasak | Memotong | Mengemas |
|----------|-----------|---------|----------|----------|
| Agus     | 65        | 75      | 60       | 70       |
| Budi     | 50        | 45      | 65       | 55       |
| Slamet   | 74        | 62      | 78       | 70       |
| Susilo   | 40        | 55      | 65       | 60       |

> Soal: Tentukan pengalokasian optimal pekerjaan pada setiap bagian ke karyawan agar diperoleh total biaya upah PALING MURAH dengan kondisi semua bagian harus terisi oleh karyawan!

### Solution Approach
Data pada tabel di atas dapat direpresentasikan ke dalam matriks berikut ini:
```yaml
65  75  60  70
50  45  65  55
74  62  78  70
40  55  65  60
```
Apabila matriks cost tersebut dimasukkan ke dalam program yang saya buat, akan didapatkan output:
![](https://i.postimg.cc/sxQFrC6J/image.png)
<br>
Program akan menampilkan hasil optimal dari algoritma dan juga rincian yang menjelaskan nilai-nilai yang harus diimplementasikan untuk mendapatkan hasil optimal tersebut.
<br>
Jadi, dari hasil rincian tersebut dapat disimpulkan bahwa:
```java
Agus ditempatkan pada tugas Memotong = 60
Budi ditempatkan pada tugas Memasak = 45
Slamet ditempatkan pada tugas Mengemas = 70
Susilo ditempatkan pada tugas Adonan = 40
---------------------------------------------------- (+)
TOTAL BIAYA OPTIMAL: 215
```
Pengecekan dengan data yang sama di website yang membuktikan bahwa hasilnya sama [click](https://www.hungarianalgorithm.com/solve.php?c=65-75-60-70--50-45-65-55--74-62-78-70--40-55-65-60)

## Repository Folder Structure

This repository contains:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `bin`: compiled output files



