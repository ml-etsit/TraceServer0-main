# Read the content of the JSON file line by line and convert each line to a JSON object
$jsonArray = Get-Content -Path "traces.json" | ForEach-Object { $_ | ConvertFrom-Json }

# Define the base URI for the server at port 8083
$baseUri = "http://localhost:8083/traces"
$headers = @{ "Content-Type" = "application/json" }

# Iterate through each JSON object and send a separate request
foreach ($jsonObject in $jsonArray) {
  $id = $jsonObject.traceId
  $uri = "$baseUri/$id"
  $body = $jsonObject | ConvertTo-Json
  Invoke-RestMethod -Uri $uri -Method Put -Body $body -Headers $headers
}