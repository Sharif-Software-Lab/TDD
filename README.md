# TDD
TDD experiment for Software Enginnering Lab Course @ SUT.

اعضای تیم:
- همراز عرفاتی ۹۹۱۰۹۷۹۹
- امیرحسین براتی ۹۹۱۰۱۳۰۸
- امیرحسین عابدی ۹۹۱۰۵۵۹۴



## بخش اول: JUnit, Coverage

## بخش دوم: پیدا کردن ۲ ایراد و توسعه Library
در ابتدا تست‌های مربوط به Student و Book را اضافه می‌کنیم. اما همانطور که انتظار داشتیم چون توابع این کلاس‌ها اکثرا از جنس getter و setter ها هستند و منطق زیادی را پیاده‌سازی نمی‌کنند تمام تست‌های این دو کلاس پاس شدند.
<img width="904" alt="image" src="https://github.com/user-attachments/assets/d0f2c07e-b94c-4019-9fd4-3c0d2f564276">
<img width="905" alt="image" src="https://github.com/user-attachments/assets/eb6457ed-00bf-494b-9952-3d0566125ac1">
<img width="285" alt="image" src="https://github.com/user-attachments/assets/379d76e0-f110-4032-be5f-c01a2e58a26d">

حال به فایل library می‌رویم که بیشتر منطق برنامه در این فایل پیاده‌سازی شده است. تست return و lend را به برنامه اضافه می‌کنیم
همانطور که می‌بینیم تست‌ها در خط ۲۴ و ۴۹ فیل می‌شوند.
<img width="1024" alt="image" src="https://github.com/user-attachments/assets/53c6a6ec-e79f-4745-a91a-5c4af628d2a1">
خط ۲۴ مربوط به زمانی است که کتاب به کسی داده می‌شود که هنوز رجیستر نشده است و باید تابع کار نکند و خط ۴۹ مربوط به این است که بعد از return کردن کتاب به کتابخانه، آن کتاب دیگر نباید در لیست کتاب‌های آن شخص وجود داشته باشد. بنابراین این دو ایراد در برنامه وجود دارند:
- کتاب ممکن است به کسی قرض داده شود که هنوز رجیستر نشده‌ است.
- بعد از پس داده شدن کتاب توسط یک شخص، کتاب از لیست کتاب‌های او حذف نمی‌شود.

این اشکالات را در فایل Library اصلاح می‌کنیم و بار دیگر تست‌ها را ران می‌کنیم.
<img width="275" alt="image" src="https://github.com/user-attachments/assets/e8d7b9bb-ec2c-4578-8c30-97cf7db8a6eb">

در ادامه می‌خواهیم توابعی که در Library ناقص هستند را کامل کنیم. قبل از اینکه این توابع را کامل کنیم تست‌هایی می‌نویسیم که مشخص می‌کنند از این توابع چه انتظاراتی داریم. بعد از اضافه کردن تست‌ها همانطور که انتظار داشتیم تمامی آن‌ها fail می‌شوند.

<img width="280" alt="image" src="https://github.com/user-attachments/assets/6de75ce6-73ff-402e-a044-19b87072a322">

حال با اضافه کردن خطوط کد به توابع درون Library تست‌ها را پاس می‌کنیم. در ابتدا تابع StudentSearch را تکمیل می‌کنیم که سرچ را بر روی دانش‌آموزان انجام می‌دهد و بعد چک می‌کنیم که تست‌ها پاس شده‌اند یا خیر
<img width="373" alt="image" src="https://github.com/user-attachments/assets/a60a4251-8ed3-4821-9e55-ba2ee5d89564">

با پاس شدن تست‌های StudentSearch به سمت BookSearch می‌رویم و تابع آن را هم تکمیل می‌کنیم. در نهایت با تکمیل کردن این تابع تمامی تست‌ها پاس می‌شوند.
<img width="427" alt="image" src="https://github.com/user-attachments/assets/938fa048-dcb8-41c7-93e6-5d317d190efe">


## سوالات
