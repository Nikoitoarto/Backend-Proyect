
# Apuntes

### BodyRequest para la gestión de del endpoint formulairo/crear:



```json
{
  "formulario": {
    "fechaFormulario": "2024-10-19T16:20:01.231Z",
    "facultad": "Ingenieria",
    "programa": "Ingeniería de Sistemas",
    "periodo": "2024-II",
    "estado": "DILIGENCIADO"
  },
  "usuarioId": 3
}
```
### Resultado del Body

```json
{
  "status": true,
  "data": {
    "id": 1,
    "state": true,
    "createdAt": "2024-10-19T11:45:28.6997177",
    "updatedAt": null,
    "deletedAt": null,
    "createdBy": 1,
    "updatedBy": null,
    "deletedBy": null,
    "fechaFormulario": "2024-10-19T16:20:01.231",
    "nombreProfesor": "Juan Pérez",
    "facultad": "Ingenieria",
    "programa": "Ingeniería de Sistemas",
    "periodo": "2024-II",
    "estado": "DILIGENCIADO",
    "actividadesAdministrativa": null,
    "actividadesCientificas": null,
    "actividadesDocencia": null,
    "actividadesLabores": null,
    "asignaturaDocencia": null,
    "revisiones": null,
    "rol": {
      "id": 1,
      "state": true,
      "createdAt": null,
      "updatedAt": null,
      "deletedAt": null,
      "createdBy": null,
      "updatedBy": null,
      "deletedBy": null,
      "tipoRol": "DOCENTE"
    }
  },
  "message": "Formulario creado exitosamente"
}
```