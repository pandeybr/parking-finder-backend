# Parking Finder Backend — Railway Deployment

## Recommended architecture

Flutter/FlutLab -> HTTPS Spring Boot API -> PostgreSQL/PostGIS

Railway can deploy the Spring Boot service and PostgreSQL. For the nearby-location query, use a PostgreSQL service/template that supports PostGIS.

## Railway steps

1. Create a Railway account.
2. Create a new project.
3. Add a PostgreSQL database.
4. For this MVP, choose a PostgreSQL/PostGIS option/template if available in the Railway marketplace.
5. Deploy this backend from GitHub or using Railway CLI.
6. Generate a public domain for the API service.
7. Set the database environment variables/reference variables for the API.

The app supports:
- DATABASE_URL
- PGUSER
- PGPASSWORD
- PORT

Railway's PostgreSQL service exposes connection variables such as DATABASE_URL, PGHOST, PGPORT, PGUSER, PGPASSWORD and PGDATABASE.

## GitHub deployment

Put this folder in a GitHub repository, then in Railway:
New Project -> Deploy from GitHub Repo -> select the repository.

Railway can detect Java/Spring Boot projects or use the included Dockerfile.

## CLI deployment

From this folder:

```bash
railway login
railway init
railway up
```

Then generate a public domain in the service Networking settings.

## Test

Once Railway gives you a domain:

```text
https://YOUR-DOMAIN/api/parking/nearby?latitude=18.5204&longitude=73.8567&radius=5000
```

You should receive JSON.

## Connect FlutLab

In:

```text
lib/services/parking_service.dart
```

set:

```dart
static const String baseUrl = 'https://YOUR-RAILWAY-DOMAIN';
```

Do not add a trailing slash.

Example:

```dart
static const String baseUrl = 'https://parking-finder-api-production.up.railway.app';
```

## Important

Do not expose PostgreSQL directly to the Flutter app. Only the Spring Boot HTTPS API should be public.

The included parking records are demo data and are not verified live availability.
