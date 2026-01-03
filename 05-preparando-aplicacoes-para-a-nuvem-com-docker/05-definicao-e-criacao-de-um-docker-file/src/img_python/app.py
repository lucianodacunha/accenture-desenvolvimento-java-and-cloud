import os
import shutil
import platform
from pathlib import Path

def running_in_docker():
    if Path("/.dockerenv").exists():
        return True
    try:
        with open("/proc/1/cgroup") as f:
            return "docker" in f.read() or "containerd" in f.read()
    except FileNotFoundError:
        return False

def running_in_kubernetes():
    return "KUBERNETES_SERVICE_HOST" in os.environ

def memory_info():
    try:
        with open("/proc/meminfo") as f:
            data = f.read()
        mem_total = int(next(l.split()[1] for l in data.splitlines() if l.startswith("MemTotal")))
        return mem_total // 1024
    except Exception:
        return None

def disk_info():
    total, used, free = shutil.disk_usage("/")
    return total // (1024**3), used // (1024**3), free // (1024**3)

def cpu_info():
    return os.cpu_count()

def interesting_envs():
    keywords = ("PATH", "PYTHON", "APP", "ENV", "HOST", "HOME")
    return {k: v for k, v in os.environ.items() if any(key in k for key in keywords)}

def main():
    print("\n🔬 Observatório do Contêiner\n")

    print(f"🖥️  Sistema: {platform.system()} {platform.release()}")
    print(f"🐍 Python: {platform.python_version()}")
    print(f"⚙️  CPUs visíveis: {cpu_info()}")

    mem = memory_info()
    if mem:
        print(f"🧠 Memória total: {mem} MB")

    total, used, free = disk_info()
    print(f"💾 Disco / → {used}GB usados de {total}GB (livre: {free}GB)")

    print("\n📦 Ambiente:")
    print("  Docker:", "sim" if running_in_docker() else "não")
    print("  Kubernetes:", "sim" if running_in_kubernetes() else "não")

    print("\n🌱 Variáveis de ambiente relevantes:")
    for k, v in interesting_envs().items():
        print(f"  {k}={v}")

    print("\n🧭 Leitura final:")
    if running_in_kubernetes():
        print("  Este processo é um cidadão de um cluster. Pense em efemeridade.")
    elif running_in_docker():
        print("  Você está isolado, mas não sozinho. Recursos são limites negociados.")
    else:
        print("  Ambiente nativo detectado. Liberdade com responsabilidade.")

    print("\n✨ Observação concluída.\n")

if __name__ == "__main__":
    main()
