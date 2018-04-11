Feature: CRUD Person dan Phone
    #Scenario Outline: Penambahan Data Person
     #   Given Ambil jumlah dari total record saat ini
      #  When Ditambahkan sebuah record baru firstName:<first>, lastName:<last>, umur:19, hp: 085271536352, no ktp: 217362763727762
       # Then Total data terakhir yaitu record awal + 1
        
        #Examples:
        #|first|last|
        #|ani|lala|
        
     #Scenario: Delete
      #  Given Ambil jumlah total record saat ini
       # When Delete id: 3
        #Then Total data terakhir adalah record awal - 1
        
     Scenario: Delete Phone
        Given Ambil semua record saat ini
        When Menghapus nomor hp pada id: 2
        Then Total dari data terakhir adalah record awal - 1
        
     #Scenario: Add Phone
    	#Given Ambil total record saat ini
        #When Menambahkan nomor hp: 0283717236162, id: 2
        #Then Data otal data terakhir adalah record awal + 1
