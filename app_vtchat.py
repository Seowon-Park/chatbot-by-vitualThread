import os
from flask import Flask, request, jsonify
from langchain.chat_models import ChatOpenAI
from langchain.chains import LLMChain
from langchain.prompts import PromptTemplate
from dotenv import load_dotenv

load_dotenv()

app = Flask(__name__)

OPENAI_API_KEY = os.getenv("OPENAI_API_KEY")
if not OPENAI_API_KEY:
    print("❌ OPENAI_API_KEY가 설정되어 있지 않습니다.")
else:
    print("✅ OPENAI_API_KEY 설정 확인")

llm = ChatOpenAI(temperature=0)
prompt = PromptTemplate.from_template("Human: {input}\nAI:")
chain = LLMChain(llm=llm, prompt=prompt)


@app.route("/chat", methods=["POST"])
def chat():
    try:
        user_input = request.json.get("message")
        if not user_input:
            return jsonify({"error": "No message provided"}), 400

        result = chain.run(input=user_input)
        return jsonify({"response": result})
    except Exception as e:
        return jsonify({"error": str(e)}), 500


if __name__ == "__main__":
    print("AI 챗봇 서버 시작...")
    app.run(port=5000)
