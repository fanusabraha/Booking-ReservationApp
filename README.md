# Booking-ReservationApp
 

## Reload changes during development

After reloading this Maven project, enable **Build project automatically** under **Settings > Build, Execution, Deployment > Compiler** in IntelliJ. Under **Settings > Advanced Settings**, enable **Allow auto-make to start even if developed application is currently running**. Restart the application once. Spring Boot DevTools restarts it after IntelliJ compiles Java changes; refresh the browser after template or static file changes. You can use **Build > Build Project** for a manual rebuild. DevTools only becomes active after restarting the running application with the new dependency.

This service runs on port 9090; stop any older copy before starting it again. Its MySQL data persists across restarts.
