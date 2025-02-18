🚨 SOS Emergency Alert
SOS Emergency Alert es una aplicación para Android que envía un SMS a un número de emergencia con un mensaje de auxilio y tu ubicación exacta (latitud, longitud y altitud) al presionar un botón de SOS.

📌 Características
📡 Obtiene automáticamente la ubicación del usuario (latitud, longitud y altitud).
📲 Envía un mensaje de texto a un número de emergencia configurado previamente.
⚡ Interfaz simple y rápida para emergencias.
🛠️ Tecnologías utilizadas
Android Studio 🏗️
Kotlin/Java ☕
API de GPS (LocationManager / FusedLocationProviderClient) 🌍
SMS Manager para el envío de mensajes 📩
📲 Instalación
Clona el repositorio:
bash
Copy code
git clone https://github.com/TU_USUARIO/SOS-Emergency-Alert.git
Abre el proyecto en Android Studio.
Conéctalo a un dispositivo Android.
Asegúrate de otorgar los permisos necesarios en AndroidManifest.xml:
xml
Copy code
<uses-permission android:name="android.permission.SEND_SMS"/>
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
Ejecuta la aplicación.
🎯 Uso
Abre la aplicación.
Configura el número de emergencia al que se enviará el SMS.
Presiona el botón de SOS.
Se enviará un mensaje con tu ubicación a dicho número.
🚨 Mensaje de auxilio (Ejemplo)
📩 Mensaje enviado:

makefile
Copy code
⚠️ ¡Emergencia! Necesito ayuda.  
📍 Ubicación:  
Latitud: 19.4326  
Longitud: -99.1332  
Altitud: 2,240m  
🔒 Permisos necesarios
Para que la app funcione correctamente, el usuario debe aceptar los permisos de ubicación y envío de SMS.

📜 Licencia
Este proyecto está bajo la licencia MIT.
