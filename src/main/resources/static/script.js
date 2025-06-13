document.addEventListener('DOMContentLoaded', function() {
  const uploadForm = document.getElementById('uploadForm');
  if (uploadForm) {
    uploadForm.addEventListener('submit', handleFormSubmit);
  }
});

async function handleFormSubmit(e) {
  e.preventDefault();

  const fileInput = document.getElementById('xmlFile');
  const uploadBtn = document.getElementById('uploadBtn');
  const loader = document.getElementById('loader');
  const resultDiv = document.getElementById('result');

  if (!fileInput.files || fileInput.files.length === 0) {
    showResult('Пожалуйста, выберите файл', 'error');
    return;
  }

  const file = fileInput.files[0];

  uploadBtn.disabled = true;
  loader.style.display = 'block';
  resultDiv.style.display = 'none';

  try {
    const formData = new FormData();
    formData.append('file', file);

    const response = await fetch('/api/xml/upload', {
      method: 'POST',
      body: formData
    });

    const result = await response.text();

    if (response.ok) {
      showResult(result, 'success');
    } else {
      showResult(`Ошибка: ${result}`, 'error');
    }
  } catch (error) {
    const errorMsg = `Сетевая ошибка: ${error.message}`;
    showResult(errorMsg, 'error');
  } finally {
    uploadBtn.disabled = false;
    loader.style.display = 'none';
  }
}

function readFileContent(file) {
  return new Promise((resolve, reject) => {
    const reader = new FileReader();
    reader.onload = (event) => resolve(event.target.result);
    reader.onerror = (error) => reject(error);
    reader.readAsText(file);
  });
}

function showResult(message, type) {
  const resultDiv = document.getElementById('result');
  if (resultDiv) {
    resultDiv.textContent = message;
    resultDiv.className = 'result ' + type;
    resultDiv.style.display = 'block';
  }
}
