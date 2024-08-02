document.addEventListener("DOMContentLoaded", function() {
    const registerButton = document.getElementById("registerButton");
    const tableBody = document.getElementById("tableBody");

    registerButton.addEventListener("click", function(event) {
        event.preventDefault();

        const continent = document.getElementById("continentSelect").value;
        const country = document.getElementById("countrySelect").value;
        const city = document.getElementById("citySelect").value;

        if (continent !== "Continent" && country !== "Country" && city !== "City") {
            const newRow = document.createElement("tr");

            const continentCell = document.createElement("td");
            continentCell.textContent = continent;
            newRow.appendChild(continentCell);

            const countryCell = document.createElement("td");
            countryCell.textContent = country;
            newRow.appendChild(countryCell);

            const cityCell = document.createElement("td");
            cityCell.textContent = city;
            newRow.appendChild(cityCell);

            const actionCell = document.createElement("td");
            const deleteButton = document.createElement("button");
            deleteButton.textContent = "Delete";
            deleteButton.classList.add("btn", "btn-danger");
            deleteButton.addEventListener("click", function() {
                tableBody.removeChild(newRow);
            });
            actionCell.appendChild(deleteButton);
            newRow.appendChild(actionCell);

            tableBody.appendChild(newRow);
        } else {
            alert("Please select a valid continent, country, and city.");
        }
    });
});
