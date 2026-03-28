🚀 API Automation Framework (RestAssured + Java)
Bu layihə professional API test avtomatlaşdırılması üçün Service Object Model (SOM) arxitekturası əsasında qurulmuşdur. Layihənin məqsədi təkrar istifadə edilə bilən, oxunaqlı və asan idarə olunan bir struktur yaratmaqdır.

📂 Layihə Strukturu və Metodologiya
1. src/main/resources/configuration.properties
Niyə: URL-lər, login məlumatları və digər sabitləri kodun içindən çıxarıb bir mərkəzdə toplamaq üçün.

Faydası: Sabah URL dəyişsə, 100 yerdə yox, sadəcə bu faylda dəyişiklik edirik.

2. utils/ConfigReader.java
Niyə: .properties faylındakı dataları Java-nın başa düşəcəyi dilə çevirmək üçün.

Faydası: ConfigReader.getProperty("base_url") yazaraq hər yerdən məlumata çatırıq.

3. models/ (POJO - Plain Old Java Objects)
Niyə: JSON formatındakı məlumatları Java obyektlərinə (və tərsinə) çevirmək üçün (Serialization/Deserialization).

Klasslar:

UserRequest: Serverə göndərdiyimiz (POST) data.

UserResponse: Serverdən gələn datanın tam strukturu.

UserModel: İstifadəçinin özünə aid təməl sahələr (id, email, name).

Lombok (@Data): Getter/Setter-ləri avtomatik yaradaraq kodu təmiz saxlayır.

4. services/UserService.java
Niyə: Bütün API sorğularını (GET, POST, PUT, DELETE) bir klassda toplamaq üçün.

Faydası: Test klasslarında sorğu kodları yazmırıq, sadəcə servisi çağırırıq. Kod təkrarının qarşısını alır.

5. tests/UserTests.java
Niyə: Bizim əsas test laboratoriyamızdır.

Məntiq: Burada ancaq Assertion (yoxlama) və Test Data olur.

Metodlar:

getSingleUserTest(): Mövcud istifadəçini yoxlayır.

createNewUserTest(): Yeni istifadəçi yaradır.

🛠 İstifadə Olunan Texnologiyalar
Java 21: Əsas proqramlaşdırma dili.

RestAssured: API sorğularını idarə etmək üçün kitabxana.

JUnit 4: Testləri qaçırtmaq və Assertions üçün.

Jackson: JSON <-> Java çevrilmələri üçün.

Lombok: Kodun həcmini azaltmaq üçün.

Maven: Layihə idarəetməsi və dependency (asılılıq) həlli üçün.

💡 Niyə bu struktur "Etalon"dur?
Separation of Concerns (Məsuliyyətlərin Ayrılması): Test kodun sorğu kodunla qarışmır.

Scalability (Böyüdülə bilən): Yeni bir API (məsələn: Products) gəlsə, sadəcə yeni bir ProductService və ProductModel əlavə edirsən, mövcud kod xarab olmur.

Maintenance (Asan İdarə): Bir endpoint dəyişsə, sadəcə Service klassında düzəliş edirsən, 50 dənə testin hamısı avtomatik düzəlir.

Readability: Testləri oxuyan kəs response.as(UserModel.class) görəndə artıq texniki detalı yox, biznes məntiqini başa düşür.
