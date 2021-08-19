# MyAxaTest

Tech stack : Kotlin, mvvm, retrofit

* Method pagination
  - pagination diperoleh dari looping dan didalam looping diberi kondisi ketika userId sama dengan page maka data akan muncul
  - tombol next/prev ditekan maka akan menambah/mengurangi page lalu diberikan kepada viewmodel dan nantinya viewmodel akan observe untuk ditampilkan oleh recyclerview
  - tombol next/prev hanya berfungsi ketika arrPost tidak null
  
